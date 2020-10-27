package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entities.User;

@Service

public class UserServiceImpl implements UserService{
	
	
	 @Autowired
	    private UserDao userDao;

	    
	
	
	 @Override
	 @Transactional
	    public void saveCustomer(User user) {
		 userDao.saveUser(user);
	    }
	@Override
		@Transactional
		public boolean checkuser(String email){
			
			boolean userInDb = false;
			if (userDao.checkuser(email) == null) userInDb = true;
			return userInDb;
		}



	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
		
	}
	@Override
	@Transactional
	public User validate(String email, String password){
		return userDao.validate(email,password);
		
	}
	

	@Override
	@Transactional

	public User viewprofile(int id)
	{
		return userDao.viewprofile(id);
	}
	

}
