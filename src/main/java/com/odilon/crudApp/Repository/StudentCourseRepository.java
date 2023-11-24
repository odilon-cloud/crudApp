package com.odilon.crudApp.Repository;

import com.odilon.crudApp.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer>{
    List<StudentCourse> findByCourse_Semester_NameAndCourse_CDefinition_Name(String semesterName, String courseName);
}
