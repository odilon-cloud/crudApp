package com.odilon.crudApp.Repository;

import com.odilon.crudApp.model.EAcademicUnit;
import com.odilon.crudApp.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;



public interface RegistrationRepository extends JpaRepository<Registration, String>{

	@Query("SELECT r.student_id, s.firstName, sem.name " +
			"FROM Registration r " +
			"JOIN r.student s " +
			"JOIN r.semester sem " +
			"WHERE sem.name = :semesterName")
	List<Object[]> findStudentsBySemester(@Param("semesterName") String semesterName);
	List<Registration> findBySemesterNameAndAcademicUnit_AcademicUnitType(String semesterName, EAcademicUnit academicUnitType);
	@Query("SELECT r.student_id, s.firstName, sem.name " +
			"FROM Registration r " +
			"JOIN r.student s " +
			"JOIN r.semester sem " +
			"JOIN r.course c " +
			"JOIN c.courseDefinition cd " +
			"WHERE sem.name = :semesterName " +
			"AND cd.name = :cdefinitionName")
	List<Object[]> findStudentsByCourseAndSemester(
			@Param("semesterName") String semesterName,
			@Param("cdefinitionName") String cdefinitionName);

}
