package com.odilon.crudApp.Repository;

import com.odilon.crudApp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface CourseRepository extends JpaRepository<Course, String>{

	@Query("SELECT c.courseDefinition.name, c.courseDefinition.course_code, c.courseDefinition.description, t.name, t.assistant_tutor " +
			"FROM Course c " +
			"JOIN c.semesterInfo sem " +
			"JOIN c.academicUnit au " +
			"JOIN c.teacher t " +
			"WHERE sem.name = :semesterName " +
			"AND au.name = :academicUnitName")
	List<Object[]> findCoursesByDepartmentAndSemester(
			@Param("semesterName") String semesterName,
			@Param("academicUnitName") String academicUnitName);
	@Query("SELECT c.courseDefinition.name, c.courseDefinition.course_code, t.name, t.assistant_tutor " +
			"FROM Course c " +
			"JOIN c.semesterInfo sem " +
			"JOIN c.academicUnit au " +
			"JOIN c.teacher t " +
			"JOIN c.student s " +
			"WHERE s.regNo = :studentRegNo")
	List<Object[]> findCoursesByStudentRegNo(@Param("studentRegNo") String studentRegNo);
}
