package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.JobProcessDao;
import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.entities.User;

@Service
public class JobProcessServiceImpl implements JobProcessService{
	
	
	 @Autowired
	    private JobProcessDao jobApplicationDao;


		@Override
		@Transactional

	public void	save (JobProcessDetails upload)
	 {
		 jobApplicationDao.save(upload);
	 }
		
		
		@Override
		@Transactional
		public boolean validate(User user){
			return jobApplicationDao.validate(user);
			
		}
		@Override
		@Transactional
		public JobApplication getJob(int id){
			return jobApplicationDao.getJob(id);
			
		}
		
}
