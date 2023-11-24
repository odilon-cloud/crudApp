package com.odilon.crudApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registration")
public class Registration {
    
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "student_id")
    private String student_id;

    @Column(name = "semester_id")
    private String semester_id;

    @Column(name = "academic_unit_id")
    private String academic_unit_id;
    @Column(name = "course_id")
    private String course_id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "regNo", insertable = false, updatable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "academic_unit_id", referencedColumnName = "code", insertable = false, updatable = false)
    private AcademicUnit academicUnit;

	public Registration() {
		super();
	}

	public Registration(String id, String student_id, String semester_id, String academic_unit_id,
						String course_id, Student student, Course course, Semester semester,
						AcademicUnit academicUnit) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.semester_id = semester_id;
		this.academic_unit_id = academic_unit_id;
		this.course_id = course_id;
		this.student = student;
		this.course = course;
		this.semester = semester;
		this.academicUnit = academicUnit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getSemester_id() {
		return semester_id;
	}

	public void setSemester_id(String semester_id) {
		this.semester_id = semester_id;
	}

	public String getAcademic_unit_id() {
		return academic_unit_id;
	}

	public void setAcademic_unit_id(String academic_unit_id) {
		this.academic_unit_id = academic_unit_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public AcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(AcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

	@Override
	public String toString() {
		return "Registration [semester=" + semester + "]";
	}

	

}
