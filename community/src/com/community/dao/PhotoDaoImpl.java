package com.community.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.RepairPhoto;

public class PhotoDaoImpl extends HibernateDaoSupport implements PhotoDao {

	public void savePho(RepairPhoto photos) {
		this.getHibernateTemplate().save(photos);
	}

}
