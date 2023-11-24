package com.odilon.crudApp.service;

import com.odilon.crudApp.Repository.TeacherRepository;
import com.odilon.crudApp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherByCode(String code) {
        return teacherRepository.findById(code);
    }

    public Teacher createOrUpdateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(String code) {
        teacherRepository.deleteById(code);
    }
}
