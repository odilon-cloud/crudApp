package com.odilon.crudApp.service;

import com.odilon.crudApp.model.Registration;
import com.odilon.crudApp.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Optional<Registration> getRegistrationById(String id) {
        return registrationRepository.findById(id);
    }

    public Registration createOrUpdateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public void deleteRegistration(String id) {
        registrationRepository.deleteById(id);
    }
}
