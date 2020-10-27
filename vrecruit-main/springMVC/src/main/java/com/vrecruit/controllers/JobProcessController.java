package com.vrecruit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.JobAppDAO;
import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.entities.User;
import com.pojo.JobProcessDetailsPOJO;
import com.service.JobProcessService;
import com.service.UserService;

@Controller

public class JobProcessController {
	@Autowired
	private JobProcessService jobProcessService;
	@Autowired
	private UserService userService;
	@Autowired
	JobAppDAO jobAppDao;
	
	
	List<JobApplication> lst;
	JobProcessDetails job;
	JobApplication jobApplication;
	User user;
	private static final String MESSAGE = "message";

//		CANDIDATE PART
	@GetMapping(value = "/candidateJobAppList")
	public ModelAndView candidateJobAppList(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();

		HttpSession session = request.getSession();

		int id = (int) session.getAttribute("id");

		user = userService.viewprofile(id);

//	    	Getting list of interviewer from database
		lst = jobAppDao.getAll();
		boolean jobs = jobProcessService.validate(user);
		if (jobs) {
			m.setViewName("CandidateJobApplicationList");
			m.addObject("lst", lst);
			
		} else {
			String msg="You have already applied for a job";
				m.addObject("msg", msg);
				m.setViewName(MESSAGE);
				

		}

		return m;
	}

	@RequestMapping(value = "/apply")
	public ModelAndView applyforjob(@RequestParam("id") int id, HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("CandidateJobApplication");
		 jobApplication = jobProcessService.getJob(id);
		HttpSession session = request.getSession();
		session.setAttribute("jid", jobApplication.getJid());
		job = new JobProcessDetails();
		mav.addObject("job", job);
		return mav;
		

	}

	@PostMapping(value = "/uploadresume")
	public ModelAndView handleFileUpload(@ModelAttribute("job") JobProcessDetailsPOJO jobPOJO, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();

		int jid = (int) session.getAttribute("jid");
		
		JobProcessDetails jobs = new JobProcessDetails();
		BeanUtils.copyProperties(jobPOJO, jobs);
		
		// save job ID
		jobApplication = jobProcessService.getJob(jid);
		jobs.setJobApplication(jobApplication);
		// save User ID
		jobs.setUser(user);
		user.setJobProcessDetails(jobs);
		String msg;
		// Save Resume
		if(jobs.getResume().getSize() != 0) {
			jobProcessService.save(jobs);
			 msg="You have successfully applied for a job";
		}
		else
		{
			 msg="No resume found! try again";
		}
		mav.addObject("msg", msg);
		
	mav.setViewName(MESSAGE);
	
		
	return mav;
	}
	@RequestMapping(value = "/status")
	public ModelAndView status(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String status;
		HttpSession session = request.getSession();

		int id = (int) session.getAttribute("id");

		user = userService.viewprofile(id);
		job = user.getJobProcessDetails();
		if(job==null)
		{
			String msg="You have not applied for a job";
			mav.addObject("msg", msg);
		mav.setViewName(MESSAGE);
		return mav;
			
		}
		mav.addObject("job", job);
		jobApplication = job.getJobApplication();
		mav.addObject("jobApplication", jobApplication);
		boolean a=job.getSelected();
		if (a) {
			if (jobApplication.getRounds() == job.getCurrentround()) {
				status = "Congrats!!!! You are selected for the applied position";
			} else {
				status = "Congrats!!!! You are selected for the next round";
			}
		} else if ( job.getCurrentround() > 0) {
			status = "Better luck next time!!";
		} else {
			status = "Waiting for interview";
		}
		mav.addObject("status", status);

		mav.setViewName("status");
		return mav;
	}
	
	
	

}
