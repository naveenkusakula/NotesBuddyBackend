package com.example.notesbuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Long programID;
	
	//<!-- Author:Added By Dhruvi Shah -->
	@Column(nullable = true)
	private String courseID;
	
	//<!-- Author:Added By Dhruvi Shah -->
	@Column(nullable = false)
	private String emailID;

	//<!-- Author:Added By Dhruvi Shah -->
	@Column(nullable = false)
	private boolean isAdmin;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProgramID(Long programID) {
		this.programID = programID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public long getProgramID() {
		return programID;
	}

	public long getId() {
		return id;
	}

	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
