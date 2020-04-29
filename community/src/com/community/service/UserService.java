package com.community.service;

import java.util.List;

import com.community.domain.User;

public interface UserService {

	public User login(User user);
	
	public User findUserByUid(String uid);
	
	public void addUser(User user);
	
	public List<User> getAllUsers();
	
	public void removeUser(User user);

	public void logOffUser(User user);
	
	public void updateUser(User user);
	
	public User findUserByUserName(String username);

	public User findUserByTel(String tel);
}
