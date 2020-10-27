package com.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Interviewer;

@Component
public class InterviewerDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public int save(Interviewer obj) {
		return (Integer) this.hibernateTemplate.save(obj);
	}

	public List<Interviewer> getAll() {

		return this.hibernateTemplate.loadAll(Interviewer.class);

	}

	public Interviewer findById(int id) {

		List<Interviewer> interviewers = this.hibernateTemplate.loadAll(Interviewer.class);

		Interviewer res = new Interviewer();
		List<Interviewer> s = interviewers.stream().filter(e -> e.getId() == id).collect(Collectors.toList());

		for (Interviewer o : s) {
			res = o;
		}
		return res;
	}

}
