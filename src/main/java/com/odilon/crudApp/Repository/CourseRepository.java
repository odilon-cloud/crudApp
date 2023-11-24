package com.odilon.crudApp.Repository;

import com.odilon.crudApp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface CourseRepository extends JpaRepository<Course, String>{

	List<Course> findBySemesterAndAcademicUnitCode(String selectedSemesterId, String selectedDepartmentId);

	List<Course> findByStudentRegNo(String selectedStudentId);

}
