package com.community.service.impl;

import java.util.List;

import com.community.dao.HistoryDao;
import com.community.domain.History;
import com.community.service.HistoryService;

public class HistoryServiceImpl implements HistoryService {
	private HistoryDao historyDao;
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
	public void addHistory(History history) {
			historyDao.addHistory(history);
	}
	public List<History> getAllHistoryByUid(String uid) {
		return historyDao.getAllHistoryByUid(uid);
	}

}
