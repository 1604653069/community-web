package com.community.dao;

import java.util.List;

import com.community.domain.Placard;

public interface PlacardDao {

	/* 获取所有的公告 */
	public List<Placard> getList();
	
	public void addPlacard(Placard placard);
	
	public Placard getPlacardByPid(int pid);
	
	public void removePlacard(Placard placard);
	
	public void updatePlacard(Placard placard);
}
