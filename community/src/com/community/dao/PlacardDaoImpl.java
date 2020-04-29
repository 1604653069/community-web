package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Placard;

public class PlacardDaoImpl extends HibernateDaoSupport implements PlacardDao {

	/* 获取所有的公告信息 */
	public List<Placard> getList() {
		return (List<Placard>) this.getHibernateTemplate().find("from Placard");
	}
	public void addPlacard(Placard placard) {
			this.getHibernateTemplate().save(placard);
	}
	public void removePlacard(Placard placard) {
		this.getHibernateTemplate().delete(placard);
	}
	public void updatePlacard(Placard placard) {
		this.getHibernateTemplate().update(placard);
	}
	public Placard getPlacardByPid(int pid) {
		List<Placard> find = (List<Placard>) this.getHibernateTemplate().find("from Placard where pid=?", pid);
		if(find!=null&&find.size()>0)
			return find.get(0);
		return null;
	}
}
