package com.odilon.crudApp.Repository;

import com.odilon.crudApp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TeacherRepository extends JpaRepository<Teacher, String>{

}
