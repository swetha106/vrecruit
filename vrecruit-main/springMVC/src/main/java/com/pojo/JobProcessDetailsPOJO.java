package com.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.entities.JobApplication;
import com.entities.User;



public class JobProcessDetailsPOJO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobid")
	private int jobid;

	private int currentround;
	private int marks;
	private boolean selected;
	
	
	private CommonsMultipartFile resume;
	

	@OneToOne
	private User user;
	@ManyToOne
	private JobApplication jobApplication;

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public JobApplication getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public int getCurrentround() {
		return currentround;
	}

	public CommonsMultipartFile getResume() {
		return resume;
	}

	public void setResume(CommonsMultipartFile resume) {
		this.resume = resume;
	}

	public void setCurrentround(int currentround) {
		this.currentround = currentround;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "JobProcessDetails [jobid=" + jobid + ", currentround=" + currentround + ", marks=" + marks
				+ ", selected=" + selected + ", resume=" + resume + ", user=" + user
				+ ", jobApplication=" + jobApplication + "]";
	}

	



}
