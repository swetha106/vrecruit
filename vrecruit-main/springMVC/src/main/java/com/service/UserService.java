package com.service;

import java.util.List;

import com.entities.User;

public interface UserService {
	
	 public void saveCustomer(User user);
	   public List < User > getUsers();

	   public User validate(String email, String password);
	   
	   public User viewprofile(int id);
	boolean checkuser(String email);
		
	   		
}
