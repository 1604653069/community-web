package com.community.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.HouseImg;

public class HouseImgDaoImpl extends HibernateDaoSupport implements HouseImgDao {

	public void addHouseImgDao(HouseImg houseImage) {
		this.getHibernateTemplate().save(houseImage);
	}
}
