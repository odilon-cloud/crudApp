package com.odilon.crudApp.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private String regNo;
    @Column(name = "firstName")
    private String firstName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

   

    public Student() {
		super();
	}

	public Student(String regNo, String firstName, Date dateOfBirth) {
        super();
        this.regNo = regNo;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
