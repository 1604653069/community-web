package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.Repair;

public class RepairDaoImpl extends HibernateDaoSupport implements RepairDao {

	//保存报事修理
	public void commitRepair(Repair repair) {
		this.getHibernateTemplate().save(repair);
	}

	public List<Repair> getAllRepair() {
		return (List<Repair>) this.getHibernateTemplate().find("from Repair");
	}

	public Repair getRepairByRid(String rid) {
		List<Repair> repairs = (List<Repair>) this.getHibernateTemplate().find("from Repair where rid=?", rid);
			if(repairs!=null&&repairs.size()>0) {
				return repairs.get(0);
			}
		return null;
	}
	public void updateRepair(Repair repair) {
			this.getHibernateTemplate().update(repair);
	}

	public List<Repair> getUserAllRepairByUid(String uid) {
		return (List<Repair>) this.getHibernateTemplate().find("from Repair where uid=?",uid);
	}	
}
