package com.community.dao;

import java.util.List;

import com.community.domain.History;

public interface HistoryDao {

	public void addHistory(History history);
	
	public List<History> getAllHistoryByUid(String uid);
}
