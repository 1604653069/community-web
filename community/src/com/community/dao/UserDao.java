package com.community.dao;

import java.util.List;

import com.community.domain.User;

public interface UserDao {

//	用户登陆
	public User login(User user);
	/* 查询用户信息 */
	public User findUserById(String uid);
	
	public void addUser(User user);

	public List<User> getAllUsers();
	
	public void removeUser(User user);
	
	//注销用户
	public void logOffUser(User user);
	
	public void updateUser(User user);
	
	public User findUserByUserName(String username);
	
	public User findUserByTel(String tel);
}
