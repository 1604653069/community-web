package com.community.service.impl;

import com.community.dao.ScoreDao;
import com.community.domain.Score;
import com.community.service.ScoreService;

public class ScoreServiceImpl implements ScoreService {
	private ScoreDao scoreDao;
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	public void updateScore(Score score) {
		this.scoreDao.updateScore(score);
	}
	public void addScore(Score score) {
		this.scoreDao.addScore(score);
	}
	public Score getUserScoreByUid(String uid) {
		return this.scoreDao.getUserScoreByUid(uid);
	}

}
