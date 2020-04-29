package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.SS;

public class SSDaoImpl extends HibernateDaoSupport implements SSDao {

	/* 获取所有的说说 */
	public List<SS> findAllSS() {
		List<SS> mySs = (List<SS>) this.getHibernateTemplate().find("from SS");
		return mySs;
	}
	
	/* 发表说说 */
	public void addSS(SS ss) {
		this.getHibernateTemplate().save(ss);
	}

	/* 删除说说 */
	public void removeSS(String sid) {
		this.getHibernateTemplate().delete(sid);
	}

	public SS getSSBySid(String sid) {
		List<SS> sses = (List<SS>) this.getHibernateTemplate().find("from SS where sid=?", sid);
		if(sses!=null&&sses.size()>0) {
			return sses.get(0);
		}
		return null;
	}

	public void removeSS(SS ss) {
		this.getHibernateTemplate().delete(ss);
	}

	public List<SS> getUserSSByUid(String uid) {
		return (List<SS>) this.getHibernateTemplate().find("from SS where uid=?", uid);
	}

}
