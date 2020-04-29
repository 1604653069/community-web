package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.community.domain.History;

@Transactional
public class HistoryDaoImpl extends HibernateDaoSupport implements HistoryDao {
	public void addHistory(History history) {
			this.getHibernateTemplate().save(history);
	}
	public List<History> getAllHistoryByUid(String uid) {
		return (List<History>) this.getHibernateTemplate().find("from History where uid=?", uid);
	}

}
