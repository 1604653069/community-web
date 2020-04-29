package com.community.service;

import java.util.List;

import com.community.domain.Repair;

public interface RepairService {
	public void commitRepair(Repair repair);
	
	public List<Repair> getAllRepair();
	
	public Repair getRepairByRid(String rid);
	
	public void updateRepair(Repair repair);

	public List<Repair> getUserAllRepairByUid(String uid);
}
