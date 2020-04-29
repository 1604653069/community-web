package com.community.service;

import com.community.domain.Score;

public interface ScoreService {

	public void updateScore(Score score);
	public void addScore(Score score);
	public Score getUserScoreByUid(String uid);
}
