package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.AuthDao;
import com.community.domain.Auth;
import com.community.service.AuthService;

@Transactional
public class AuthServiceImpl implements AuthService {

	private AuthDao authDao;
	public void setAuthDao(AuthDao authDao) {
		this.authDao = authDao;
	}

	public List<Auth> getAllAuth() {
			return this.authDao.getAllAuth();
	}

	public Auth getAllAuthByAid(String aid) {
			return this.authDao.getAllAuthByAid(aid);
	}

	public void updateAuth(Auth auth) {
			this.authDao.updateAuth(auth);
	}

	public Auth getAuthByUid(String uid) {
		return this.authDao.getAuthByUid(uid);
	}

	public void addAuth(Auth auth) {
			this.authDao.addAuth(auth);
	}

}
