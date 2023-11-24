package com.odilon.crudApp.service;

import com.odilon.crudApp.Repository.StudentRepository;
import com.odilon.crudApp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String regNo) {
        return studentRepository.findById(regNo);
    }

    public Student createOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String regNo) {
        studentRepository.deleteById(regNo);
    }
}
