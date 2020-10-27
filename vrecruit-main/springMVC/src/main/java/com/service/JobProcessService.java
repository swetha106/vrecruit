package com.service;

import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.entities.User;


public interface JobProcessService {
	
	public void	save (JobProcessDetails upload);

	public boolean validate(User user);

	public JobApplication getJob(int id);
	 

}
