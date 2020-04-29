package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.RepairDao;
import com.community.domain.Repair;
import com.community.service.RepairService;

@Transactional
public class RepairServiceImpl implements RepairService {
	private RepairDao repairDao;
	public void setRepairDao(RepairDao repairDao) {
		this.repairDao = repairDao;
	}
	
	public void commitRepair(Repair repair) {
		repairDao.commitRepair(repair);
	}

	public List<Repair> getAllRepair() {
		return repairDao.getAllRepair();
	}

	public Repair getRepairByRid(String rid) {
		return repairDao.getRepairByRid(rid);
	}

	public void updateRepair(Repair repair) {
		repairDao.updateRepair(repair);
	}

	public List<Repair> getUserAllRepairByUid(String uid) {
		return repairDao.getUserAllRepairByUid(uid);
	}

}
