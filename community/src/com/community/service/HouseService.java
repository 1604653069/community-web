package com.community.service;

import java.util.List;

import com.community.domain.House;

public interface HouseService {

	public List<House> getAllHouseInfo();
	
	public House getHouseByHid(String hid);

	public void addHouse(House house);
	
	public void updateHouse(House house);
	
	public void removeHouse(House house);
	
	public List<House> getHouseBySort(String hql);
}
