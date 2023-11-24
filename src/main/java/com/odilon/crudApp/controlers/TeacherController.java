package com.odilon.crudApp.controlers;

import com.odilon.crudApp.model.Teacher;
import com.odilon.crudApp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Teacher> getTeacherByCode(@PathVariable String code) {
        Optional<Teacher> teacher = teacherService.getTeacherByCode(code);
        return teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createOrUpdateTeacher(teacher);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable String code, @RequestBody Teacher teacherDetails) {
        Optional<Teacher> existingTeacher = teacherService.getTeacherByCode(code);
        if (existingTeacher.isPresent()) {
            teacherDetails.setCode(code); // Ensure code is set for update
            Teacher updatedTeacher = teacherService.createOrUpdateTeacher(teacherDetails);
            return ResponseEntity.ok(updatedTeacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String code) {
        teacherService.deleteTeacher(code);
        return ResponseEntity.noContent().build();
    }
}

