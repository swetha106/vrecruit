package com.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.entities.JobApplication;


public class InterviewerPOJO {
	
	
	private int id;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String designation;
	
	private int phone;
	
	@OneToMany(mappedBy = "interviewer",fetch = FetchType.EAGER)
	private  List<JobApplication> jobApplication=new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<JobApplication> getjobApplication() {
		return jobApplication;
	}

	public void setjobApplication(List<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}

	@Override
	public String toString() {
		return "Interviewer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", designation=" + designation + ", phone_no=" + phone + "]";
	}

	

	
	
	
}
