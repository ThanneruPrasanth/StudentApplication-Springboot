package com.student.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	private String firstname;
	private String lastname;
	private int s_class;
	private String dob;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getS_class() {
		return s_class;
	}

	public void setS_class(int s_class) {
		this.s_class = s_class;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Student(int sId, String firstname, String lastname, int s_class, String dob) {
		super();
		this.sId = sId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.s_class = s_class;
		this.dob = dob;
	}

	public Student() {
		super();
	}

}
