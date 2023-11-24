package com.odilon.crudApp.controlers;

import com.odilon.crudApp.model.StudentCourse;
import com.odilon.crudApp.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-courses")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping
    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseService.getAllStudentCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCourse> getStudentCourseById(@PathVariable int id) {
        Optional<StudentCourse> studentCourse = studentCourseService.getStudentCourseById(id);
        return studentCourse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentCourse> createStudentCourse(@RequestBody StudentCourse studentCourse) {
        StudentCourse createdStudentCourse = studentCourseService.createOrUpdateStudentCourse(studentCourse);
        return new ResponseEntity<>(createdStudentCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentCourse> updateStudentCourse(@PathVariable int id, @RequestBody StudentCourse studentCourseDetails) {
        Optional<StudentCourse> existingStudentCourse = studentCourseService.getStudentCourseById(id);
        if (existingStudentCourse.isPresent()) {
            studentCourseDetails.setID(id); // Ensure ID is set for update
            StudentCourse updatedStudentCourse = studentCourseService.createOrUpdateStudentCourse(studentCourseDetails);
            return ResponseEntity.ok(updatedStudentCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentCourse(@PathVariable int id) {
        studentCourseService.deleteStudentCourse(id);
        return ResponseEntity.noContent().build();
    }
}

