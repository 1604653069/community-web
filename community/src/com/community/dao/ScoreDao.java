package com.community.dao;

import com.community.domain.Score;

public interface ScoreDao {

	public void updateScore(Score score);
	public void addScore(Score score);
	public Score getUserScoreByUid(String uid);
}
