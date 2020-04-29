package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.House;

public class HouseDaoImpl extends HibernateDaoSupport implements HouseDao {

	//获取所有的房屋信息
	public List<House> getAllHouseInfo() {
		return (List<House>) this.getHibernateTemplate().find("from House");
	}

	public House getHouseByHid(String hid) {
		return (House) this.getHibernateTemplate().find("from House where hid=?", hid).get(0);
	}

	public void addHouse(House house) {
			this.getHibernateTemplate().save(house);
	}

	public void updateHouse(House house) {
			this.getHibernateTemplate().update(house);
	}

	public void removeHouse(House house) {
			this.getHibernateTemplate().delete(house);
	}

	public List<House> getHouseBySort(String hql) {
		return (List<House>) this.getHibernateTemplate().find(hql);
	}

}
