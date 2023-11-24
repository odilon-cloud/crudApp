package com.odilon.crudApp.service;

import com.odilon.crudApp.Repository.SemesterRepository;
import com.odilon.crudApp.model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Optional<Semester> getSemesterById(String id) {
        return semesterRepository.findById(id);
    }

    public Semester createOrUpdateSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    public void deleteSemester(String id) {
        semesterRepository.deleteById(id);
    }
}

