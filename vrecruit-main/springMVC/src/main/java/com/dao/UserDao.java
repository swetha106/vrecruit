package com.dao;

import java.util.List;

import com.entities.User;


public interface UserDao {
	
	public void saveUser(User user);

	public List<User> getUsers();
	 public User validate(String email, String password); 
	 public User viewprofile(int id);

	public User checkuser(String email);

	

}
