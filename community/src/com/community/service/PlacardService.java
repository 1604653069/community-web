package com.community.service;

import java.util.List;

import com.community.domain.Placard;

public interface PlacardService {

	public List<Placard> getList();
	
	public void addPlacard(Placard placard);
	
	
	public void removePlacard(Placard placard);
	
	public void updatePlacard(Placard placard);

	public Placard getPlacardByPid(int pid);
}
