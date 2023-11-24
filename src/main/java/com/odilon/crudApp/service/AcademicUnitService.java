package com.odilon.crudApp.service;

import com.odilon.crudApp.Repository.AcademicUnitRepository;
import com.odilon.crudApp.model.AcademicUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicUnitService {

    @Autowired
    private AcademicUnitRepository academicUnitRepository;

    public List<AcademicUnit> getAllAcademicUnits() {
        return academicUnitRepository.findAll();
    }

    public Optional<AcademicUnit> getAcademicUnitByCode(String code) {
        return academicUnitRepository.findById(code);
    }

    public AcademicUnit createOrUpdateAcademicUnit(AcademicUnit academicUnit) {
        return academicUnitRepository.save(academicUnit);
    }

    public void deleteAcademicUnit(String code) {
        academicUnitRepository.deleteById(code);
    }
}

