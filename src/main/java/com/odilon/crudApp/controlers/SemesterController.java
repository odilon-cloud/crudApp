package com.odilon.crudApp.controlers;

import com.odilon.crudApp.model.Semester;
import com.odilon.crudApp.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/semesters")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @GetMapping
    public List<Semester> getAllSemesters() {
        return semesterService.getAllSemesters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semester> getSemesterById(@PathVariable String id) {
        Optional<Semester> semester = semesterService.getSemesterById(id);
        return semester.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) {
        Semester createdSemester = semesterService.createOrUpdateSemester(semester);
        return new ResponseEntity<>(createdSemester, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semester> updateSemester(@PathVariable String id, @RequestBody Semester semesterDetails) {
        Optional<Semester> existingSemester = semesterService.getSemesterById(id);
        if (existingSemester.isPresent()) {
            semesterDetails.setId(id); // Ensure ID is set for update
            Semester updatedSemester = semesterService.createOrUpdateSemester(semesterDetails);
            return ResponseEntity.ok(updatedSemester);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemester(@PathVariable String id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.noContent().build();
    }
}
