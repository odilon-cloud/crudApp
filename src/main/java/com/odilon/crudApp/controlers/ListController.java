package com.odilon.crudApp.controlers;

import com.odilon.crudApp.Repository.RegistrationRepository;
import com.odilon.crudApp.Repository.StudentCourseRepository;
import com.odilon.crudApp.model.EAcademicUnit;
import com.odilon.crudApp.model.Registration;
import com.odilon.crudApp.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {

    @Autowired
    private RegistrationRepository registrationRepository;



    @GetMapping("/students-by-semester")
    public ResponseEntity<List<Object[]>> getStudentsBySemester(@RequestParam String semesterName) {
        List<Object[]> students = registrationRepository.findStudentsBySemester(semesterName);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/students-by-department-semester")
    public ResponseEntity<List<Registration>> getStudentsByDepartmentAndSemester(
            @RequestParam String semesterName,
            @RequestParam EAcademicUnit academicUnitType) {

        List<Registration> students = registrationRepository.findBySemesterNameAndAcademicUnit_AcademicUnitType(semesterName, academicUnitType);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students-by-course-semester")
    public ResponseEntity<List<Object[]>> getStudentsByCourseAndSemester(@RequestParam String semesterName, @RequestParam String cdefinitionName) {

        List<Object[]> students = registrationRepository.findStudentsByCourseAndSemester(semesterName, cdefinitionName);

        return ResponseEntity.ok(students);
    }



}
