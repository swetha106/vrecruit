package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.entities.User;

@Repository
@Transactional
public class JobProcessDaoImpl implements JobProcessDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	HibernateTemplate hibernateTemplate;

	public JobProcessDaoImpl() {
	}

	public JobProcessDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(JobProcessDetails uploadFile) {

		sessionFactory.getCurrentSession().save(uploadFile);

	}

	@Override
	public boolean validate(User user) {
		JobProcessDetails users = null;
		boolean a;
		try (Session session = sessionFactory.openSession()) {
			users = (JobProcessDetails) session.createQuery("FROM JobProcessDetails U WHERE U.user = :user ")
					.setParameter("user", user).uniqueResult();

		}
		if (users == null)
			a=true;
		else
			a= false;
		return a;
	}

	@Override
	public JobApplication getJob(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(JobApplication.class, id);
		

	}

	@Override
	public List<JobProcessDetails> getCandidatesJobProcess(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session
					.createQuery("FROM JobProcessDetails U WHERE U.jobApplication.id = " + id).list();
			
		}
	}

	@Transactional
	@Override
	public List<JobProcessDetails> update(JobProcessDetails obj) {
		this.hibernateTemplate.saveOrUpdate(obj);
		return this.hibernateTemplate.loadAll(JobProcessDetails.class);
		 

	}

	@Override
	public JobProcessDetails findById(int id) {
		try (Session session = sessionFactory.openSession()) {
		return  
				(JobProcessDetails) session.createQuery("FROM JobProcessDetails U WHERE U.jobid = :id ")
				.setParameter("id", id).uniqueResult();
		}
	}

}
