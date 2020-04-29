package com.community.dao;

import java.util.List;

import com.community.domain.Auth;

public interface AuthDao {

	//获取所有的认证信息
	public List<Auth> getAllAuth();
	
	public Auth getAllAuthByAid(String aid);
	//更新
	public void updateAuth(Auth auth);
	
	public Auth getAuthByUid(String uid);
	
	public void addAuth(Auth auth);
}
