package com.vrecruit.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.InterviewerDAO;
import com.dao.JobAppDAO;
import com.dao.JobProcessDao;
import com.entities.JobAppCategory;
import com.entities.JobAppPositionType;
import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.pojo.JobApplicationPOJO;
import com.pojo.JobProcessDetailsPOJO;

@RequestMapping("/jobApp")
@Controller
public class JobAppController {

	private static final Logger logger = Logger.getLogger(JobAppController.class);

	private static final String NO_APPLICATION_FOUND = "noApplicationFound";
	private static final String POSITION_TYPE = "positionType";
	private static final String JOB_APPLICATION_LIST = "JobApplicationList";
	private static final String CATEGORIES = "categories";

	@Autowired
	JobAppDAO jobAppDao;

	@Autowired
	JobProcessDao jobProcessDaoImpl;

	@Autowired
	InterviewerDAO interviewerDao;

	List<JobApplication> lst;

	List<JobProcessDetails> jobProcessDetailsList;

	List<JobAppCategory> categoriesList = Arrays.asList(JobAppCategory.values());
	List<JobAppPositionType> positionType = Arrays.asList(JobAppPositionType.values());

	@RequestMapping("/create")
	public ModelAndView create(ModelAndView m) {
		m.setViewName("createJobApplication");
		m.addObject("jobApp", new JobApplication());
		m.addObject(CATEGORIES, categoriesList);
		m.addObject(POSITION_TYPE, positionType);
		return m;
	}

	@PostMapping(value = "/add")
	public ModelAndView add(@Valid @ModelAttribute("jobApp") JobApplicationPOJO jobAppPojo, BindingResult br,
			HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		HttpSession session = request.getSession();

		JobApplication jobApp = new JobApplication();
		BeanUtils.copyProperties(jobAppPojo, jobApp);

		logger.info(jobApp + "JOB APP POJO---------------------" + jobAppPojo);

		int id = (Integer) session.getAttribute("interviewerId");
		logger.info(categoriesList.contains(jobApp.getCategory()));
		if (br.hasErrors() || !categoriesList.contains(jobApp.getCategory())) {

			if (!categoriesList.contains(jobApp.getCategory())) {
				m.addObject("CategoryError", "Category not Selected");
			}
			logger.info(br.toString());
			m.addObject(CATEGORIES, categoriesList);
			m.addObject(POSITION_TYPE, positionType);
			m.setViewName("createJobApplication");
		} else {

			jobApp.setInterviewer(interviewerDao.findById(id));

			m.setViewName(JOB_APPLICATION_LIST);
			// Setting object from form to db
			jobAppDao.save(jobApp);

			// Getting list of interviewer from database
			lst = jobAppDao.getAll();

			m.addObject("lst", lst);
		}

		return m;
	}

	// This will get and display all the data of job applications which are there
	@GetMapping(value = "/viewAll")
	public ModelAndView show() {
		ModelAndView m = new ModelAndView();

		m.setViewName(JOB_APPLICATION_LIST);

//    	Getting list of interviewer from database
		lst = jobAppDao.getAll();

		m.addObject("lst", lst);

		return m;
	}

	// This will get and display all the data of job applications which are there
	@GetMapping(value = "/view")
	public ModelAndView show(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();

		m.setViewName(JOB_APPLICATION_LIST);

		HttpSession session = request.getSession();

		int id = (int) session.getAttribute("interviewerId");
		logger.info("id get while fetching for list of JA:  " + id);
//    	Getting list of interviewer from database
		lst = jobAppDao.findByInterviewerId(id);

		m.addObject("lst", lst);

		return m;
	}

	@GetMapping(value = "/edit")
	public ModelAndView edit(@RequestParam("id") int id) {

		ModelAndView m = new ModelAndView();
		JobApplication job = new JobApplication();
		for (JobApplication i : lst) {
			if (i.getJid() == id) {
				job = i;
			}
		}
		m.addObject(CATEGORIES, categoriesList);
		m.addObject(POSITION_TYPE, positionType);
		m.setViewName("EditJobApp");
		m.addObject("jobApp", job);
		return m;
	}

	@PostMapping(value = "/update")
	public ModelAndView update(@ModelAttribute("jobApp") JobApplicationPOJO jobPojo, BindingResult bindingResult) {
		ModelAndView m = new ModelAndView();

		JobApplication jobApp = new JobApplication();
		BeanUtils.copyProperties(jobPojo, jobApp);


		m.setViewName(JOB_APPLICATION_LIST);
		logger.info("UPDATINGGG-----" + jobApp + "jobpojo-----" + jobPojo);
		// update function will return the updated list
		lst = jobAppDao.update(jobApp);

		m.addObject("lst", lst);

		return m;
	}

	@GetMapping(value = "/delete")
	public ModelAndView delete(@RequestParam("id") int id){
		ModelAndView m = new ModelAndView();
		m.setViewName(JOB_APPLICATION_LIST);
		jobProcessDetailsList = jobProcessDaoImpl.getCandidatesJobProcess(id);
		for (JobApplication i : lst) {
			if (i.getJid() == id) {
				if (jobProcessDetailsList.stream().anyMatch(j -> j.getJobApplication().getJid() == id)) {
					throw new DataIntegrityViolationException(
							"Candidates Have already Applied ...you can edit but..Can't Delete ");
				}
				jobAppDao.delete(i);
				break;
			}
		}
		lst = jobAppDao.getAll();
		m.addObject("lst", lst);
		return m;
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ModelAndView handleIOException(Exception ex) {
		ModelAndView model = new ModelAndView("jobAppDeleteError");

		model.addObject("exception", ex.getMessage());

		return model;
	}

//	CANDIDATE PART
	@GetMapping(value = "/candidateJobAppList")
	public ModelAndView candidateJobAppList() {
		ModelAndView m = new ModelAndView();

		m.setViewName("CandidateJobApplicationList");

//    	Getting list of interviewer from database
		lst = jobAppDao.getAll();

		m.addObject("lst", lst);

		return m;
	}

	// by priyank
	// to get all job process details by passing job Application id
	@RequestMapping(value = "/viewCandidates")
	public ModelAndView seeCandidateJobProcess(@RequestParam("id") int id, HttpServletRequest request) {
		ModelAndView m = new ModelAndView();

		m.setViewName("candidatesList");
		jobProcessDetailsList = jobProcessDaoImpl.getCandidatesJobProcess(id);

		if (jobProcessDetailsList.isEmpty()) {
			m.addObject(NO_APPLICATION_FOUND, true);
		} else {
			m.addObject(NO_APPLICATION_FOUND, false);
			m.addObject("jobAppName", jobProcessDetailsList.get(0).getJobApplication().getTitle());
			m.addObject("lst", jobProcessDetailsList);
		}

		return m;
	}

	@RequestMapping(value = "/viewCandidateJobProfile")
	public ModelAndView viewCandidateJobProfile(@RequestParam("id") int id, HttpServletRequest request) {
		ModelAndView m = new ModelAndView();

		m.setViewName("SingleCandidateDetails");

		JobProcessDetails candidateJobProcessDetails = new JobProcessDetails();

		for (JobProcessDetails j : jobProcessDetailsList) {
			if (j.getJobid() == id) {
				candidateJobProcessDetails = j;
			}
		}

		m.addObject("candidateDetails", candidateJobProcessDetails);
		return m;
	}

	@RequestMapping(value = "/updateCandidateJobProcess")
	public ModelAndView updateCandidateJobProcess(
			@ModelAttribute("candidateDetails") JobProcessDetailsPOJO candidateDetailsPojo,
			BindingResult bindingResult) {
		ModelAndView m = new ModelAndView();
		m.addObject(NO_APPLICATION_FOUND, false);
		m.setViewName("candidatesList");

		JobProcessDetails candidateDetails = new JobProcessDetails();
		BeanUtils.copyProperties(candidateDetailsPojo, candidateDetails);

		logger.info(candidateDetails);

		JobProcessDetails oldJobProcess = jobProcessDaoImpl.findById(candidateDetails.getJobid());
		candidateDetails.setResume(oldJobProcess.getResume());
		candidateDetails.setUser(oldJobProcess.getUser());
		candidateDetails.setJobApplication(oldJobProcess.getJobApplication());

		// update function will return the updated list
		jobProcessDetailsList = jobProcessDaoImpl.update(candidateDetails);
		logger.info(candidateDetails);
		m.addObject("lst", jobProcessDetailsList);

		return m;
	}

	@RequestMapping(value = "/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") int id, HttpServletRequest request) {
		JobProcessDetails candidateJobProcessDetails = new JobProcessDetails();

		for (JobProcessDetails j : jobProcessDetailsList) {
			if (j.getJobid() == id) {
				candidateJobProcessDetails = j;
			}
		}

		CommonsMultipartFile resume = candidateJobProcessDetails.getResume();

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(resume.getContentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + resume.getOriginalFilename())
				.body(new ByteArrayResource(resume.getBytes()));

	}

}
