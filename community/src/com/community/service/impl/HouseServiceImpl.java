package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.HouseDao;
import com.community.domain.House;
import com.community.service.HouseService;

@Transactional
public class HouseServiceImpl implements HouseService {

	private HouseDao houseDao;
	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	
	public List<House> getAllHouseInfo() {
		return houseDao.getAllHouseInfo();
	}

	public House getHouseByHid(String hid) {
		return houseDao.getHouseByHid(hid);
	}

	public void addHouse(House house) {
		houseDao.addHouse(house);
	}

	public void updateHouse(House house) {
		houseDao.updateHouse(house);
	}

	public void removeHouse(House house) {
		houseDao.removeHouse(house);
	}

	public List<House> getHouseBySort(String hql) {
		return houseDao.getHouseBySort(hql);
	}

}
