package com.odilon.crudApp.controlers;

import com.odilon.crudApp.model.Registration;
import com.odilon.crudApp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable String id) {
        Optional<Registration> registration = registrationService.getRegistrationById(id);
        return registration.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration) {
        Registration createdRegistration = registrationService.createOrUpdateRegistration(registration);
        return new ResponseEntity<>(createdRegistration, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable String id, @RequestBody Registration registrationDetails) {
        Optional<Registration> existingRegistration = registrationService.getRegistrationById(id);
        if (existingRegistration.isPresent()) {
            registrationDetails.setId(id); // Ensure ID is set for update
            Registration updatedRegistration = registrationService.createOrUpdateRegistration(registrationDetails);
            return ResponseEntity.ok(updatedRegistration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable String id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }
}
