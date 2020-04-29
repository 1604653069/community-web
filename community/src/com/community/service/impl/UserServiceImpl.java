package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.UserDao;
import com.community.domain.User;
import com.community.service.UserService;
@Transactional
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User login(User user) {
		return userDao.login(user);
	}
	public User findUserByUid(String uid) {
		return userDao.findUserById(uid);
	}
	public void addUser(User user) {
		userDao.addUser(user);
	}
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	public void removeUser(User user) {
		userDao.removeUser(user);
	}
	public void logOffUser(User user) {
		userDao.logOffUser(user);
	}
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}
	public User findUserByTel(String tel) {
		return userDao.findUserByTel(tel);
	}

}
