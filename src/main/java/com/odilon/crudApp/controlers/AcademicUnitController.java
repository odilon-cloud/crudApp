package com.odilon.crudApp.controlers;

import com.odilon.crudApp.model.AcademicUnit;
import com.odilon.crudApp.service.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academic-units")
public class AcademicUnitController {

    @Autowired
    private AcademicUnitService academicUnitService;

    @GetMapping
    public List<AcademicUnit> getAllAcademicUnits() {
        return academicUnitService.getAllAcademicUnits();
    }

    @GetMapping("/{code}")
    public ResponseEntity<AcademicUnit> getAcademicUnitByCode(@PathVariable String code) {
        Optional<AcademicUnit> academicUnit = academicUnitService.getAcademicUnitByCode(code);
        return academicUnit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AcademicUnit> createAcademicUnit(@RequestBody AcademicUnit academicUnit) {
        AcademicUnit createdAcademicUnit = academicUnitService.createOrUpdateAcademicUnit(academicUnit);
        return new ResponseEntity<>(createdAcademicUnit, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<AcademicUnit> updateAcademicUnit(@PathVariable String code, @RequestBody AcademicUnit academicUnitDetails) {
        Optional<AcademicUnit> existingAcademicUnit = academicUnitService.getAcademicUnitByCode(code);
        if (existingAcademicUnit.isPresent()) {
            academicUnitDetails.setCode(code); // Ensure code is set for update
            AcademicUnit updatedAcademicUnit = academicUnitService.createOrUpdateAcademicUnit(academicUnitDetails);
            return ResponseEntity.ok(updatedAcademicUnit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteAcademicUnit(@PathVariable String code) {
        academicUnitService.deleteAcademicUnit(code);
        return ResponseEntity.noContent().build();
    }
}

