package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.JobApplication;

@Component
public class JobAppDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int save(JobApplication obj) {
		return (Integer) this.hibernateTemplate.save(obj);

	}
	
	public List<JobApplication> getAll(){
		
		return this.hibernateTemplate.loadAll(JobApplication.class);

	}
	
	public List<JobApplication> findByInterviewerId(int id){	
		return (List<JobApplication>) this.hibernateTemplate.
				find("from JobApplication j where j.interviewer.id = "+id);

	}
    		
	
	@Transactional
	public List<JobApplication> update(JobApplication obj){
		 this.hibernateTemplate.saveOrUpdate(obj); 
		 return  this.hibernateTemplate.loadAll(JobApplication.class);
		 
	}
	
	@Transactional
	public void delete(JobApplication obj) {
		this.hibernateTemplate.delete(obj);
	}
	
	
	
}
