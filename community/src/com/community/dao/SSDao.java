package com.community.dao;

import java.util.List;

import com.community.domain.SS;

public interface SSDao {

	/* 获取所有的说说 */
	public List<SS> findAllSS();

	/* 发表说说 */
	public void addSS(SS ss);
	
	/* 删除说说 */
	public void removeSS(String sid);
	
	public SS getSSBySid(String sid);
	
	public void removeSS(SS ss);
	
	public List<SS> getUserSSByUid(String uid);
}
