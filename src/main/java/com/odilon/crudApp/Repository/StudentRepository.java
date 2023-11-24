package com.odilon.crudApp.Repository;

import com.odilon.crudApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
