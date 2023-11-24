package com.odilon.crudApp.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "studentcourse")
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
 
    @Column(name = "ID")
    private int ID;

    @Column(name = "studentID")
    private String studentID;

    @Column(name = "courseID")
    private String courseID;

    @Column(name = "credits")
    private int credits;

    @Column(name = "results")
    private double results;

    @ManyToOne
    @JoinColumn(name = "studentID", referencedColumnName = "id", insertable = false, updatable = false)
    private Registration registration;

    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

 

	public StudentCourse() {
		super();
	}



	public StudentCourse(int ID, String studentID, String courseID, int credits, double results,
						 Registration registration, Course course) {
		super();
		this.ID = ID;
		this.studentID = studentID;
		this.courseID = courseID;
		this.credits = credits;
		this.results = results;
		this.registration = registration;
		this.course = course;
	}



	public int getID() {
		return ID;
	}



	public void setID(int ID) {
		this.ID = ID;
	}



	public String getStudentID() {
		return studentID;
	}



	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}



	public String getCourseID() {
		return courseID;
	}



	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}



	public int getCredits() {
		return credits;
	}



	public void setCredits(int credits) {
		this.credits = credits;
	}



	public double getResults() {
		return results;
	}



	public void setResults(double results) {
		this.results = results;
	}



	public Registration getRegistration() {
		return registration;
	}



	public void setRegistration(Registration registration) {
		this.registration = registration;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}




	
}
