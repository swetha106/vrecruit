package com.pojo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.entities.Interviewer;
import com.entities.JobAppCategory;
import com.entities.JobAppPositionType;



public class JobApplicationPOJO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jid;
	
	
	@Size(min=1,message="Title can't be empty")
	private String title;
	
	@Enumerated(EnumType.STRING)
	private JobAppCategory category;
	
	@Enumerated(EnumType.STRING)
	private JobAppPositionType positionType;
	
	private String jobDescription;
	
	private int rounds;
	
	@ManyToOne
	private Interviewer interviewer;

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public JobAppCategory getCategory() {
		return category;
	}

	public void setCategory(JobAppCategory category) {
		this.category = category;
	}

	public JobAppPositionType getPositionType() {
		return positionType;
	}

	public void setPositionType(JobAppPositionType positionType) {
		this.positionType = positionType;
	}

	

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	@Override
	public String toString() {
		return "JobApplication [jid=" + jid + ", title=" + title + ", category=" + category + ", positionType="
				+ positionType + ", jobDescription=" + jobDescription + ", rounds=" + rounds + ", interviewer="
				+ interviewer + "]";
	}
	
	

}
