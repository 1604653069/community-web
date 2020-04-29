package com.community.service;

import java.util.List;

import com.community.domain.History;

public interface HistoryService {

	public void addHistory(History history);
	
	public List<History> getAllHistoryByUid(String uid);
}
