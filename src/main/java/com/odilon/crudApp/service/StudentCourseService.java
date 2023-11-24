package com.odilon.crudApp.service;

import com.odilon.crudApp.model.StudentCourse;
import com.odilon.crudApp.Repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseRepository.findAll();
    }

    public Optional<StudentCourse> getStudentCourseById(int id) {
        return studentCourseRepository.findById(id);
    }

    public StudentCourse createOrUpdateStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    public void deleteStudentCourse(int id) {
        studentCourseRepository.deleteById(id);
    }
}
