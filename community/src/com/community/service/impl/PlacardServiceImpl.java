package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.PlacardDao;
import com.community.domain.Placard;
import com.community.service.PlacardService;

@Transactional
public class PlacardServiceImpl implements PlacardService {
	private PlacardDao placardDao;
	public void setPlacardDao(PlacardDao placardDao) {
		this.placardDao = placardDao;
	}
	public List<Placard> getList() {
		return placardDao.getList();
	}
	public void addPlacard(Placard placard) {
		placardDao.addPlacard(placard);
	}
	public Placard getPlacardByPid(int pid) {
		return placardDao.getPlacardByPid(pid);
	}
	public void removePlacard(Placard placard) {
		placardDao.removePlacard(placard);
	}
	public void updatePlacard(Placard placard) {
		placardDao.updatePlacard(placard);
	}

}
