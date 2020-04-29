package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.community.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	/* 用户登陆 */
	public User login(User user) {
		List<User> users = (List<User>) this.getHibernateTemplate().find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		if(users.size()>0) {
			return users.get(0);
		}
		return null;
	}

	public User findUserById(String uid) {
		 List<User> users = (List<User>)this.getHibernateTemplate().find("from User where uid=?", uid);
		 if(users.size()>0)
			 return users.get(0);
		 return null;
	}

	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	public List<User> getAllUsers() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}


	public void removeUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

	public void logOffUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	public User findUserByUserName(String username) {
		List<User> users = (List<User>) this.getHibernateTemplate().find("from User where username=?",username);
		if(users!=null&&users.size()>0){
			return users.get(0);
		}
		return null;
	}

	public User findUserByTel(String tel) {
		List<User> users = (List<User>) this.getHibernateTemplate().find("from User where tel=?",tel);
		if(users!=null&&users.size()>0){
			return users.get(0);
		}
		return null;
	}

}
