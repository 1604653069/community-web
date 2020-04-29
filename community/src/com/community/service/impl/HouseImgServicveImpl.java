package com.community.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.HouseImgDao;
import com.community.domain.HouseImg;
import com.community.service.HouseImgService;
@Transactional
public class HouseImgServicveImpl implements HouseImgService {

	private HouseImgDao houseImgDao;
	
	public void setHouseImgDao(HouseImgDao houseImgDao) {
		this.houseImgDao = houseImgDao;
	}
	public void addHouseImg(HouseImg houseImg) {
		houseImgDao.addHouseImgDao(houseImg);
	}

}
