package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.community.domain.Score;

@Transactional
public class ScoreDaoImpl extends HibernateDaoSupport implements ScoreDao {

	//更新积分
	public void updateScore(Score score) {
		this.getHibernateTemplate().update(score);
	}

	public void addScore(Score score) {
		this.getHibernateTemplate().save(score);
	}

	public Score getUserScoreByUid(String uid) {
		List<Score> scores = (List<Score>) this.getHibernateTemplate().find("from Score where uid=?", uid);
			if(scores!=null&&scores.size()>0) {
				return scores.get(0);
			}
		return null;
	}

}
