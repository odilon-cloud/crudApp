package com.odilon.crudApp.controlers;

import com.odilon.crudApp.model.Student;
import com.odilon.crudApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{regNo}")
    public ResponseEntity<Student> getStudentById(@PathVariable String regNo) {
        Optional<Student> student = studentService.getStudentById(regNo);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createOrUpdateStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{regNo}")
    public ResponseEntity<Student> updateStudent(@PathVariable String regNo, @RequestBody Student studentDetails) {
        Optional<Student> existingStudent = studentService.getStudentById(regNo);
        if (existingStudent.isPresent()) {
            Student updatedStudent = studentService.createOrUpdateStudent(studentDetails);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{regNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String regNo) {
        studentService.deleteStudent(regNo);
        return ResponseEntity.noContent().build();
    }
}


