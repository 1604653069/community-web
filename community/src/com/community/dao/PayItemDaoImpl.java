package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.community.domain.PayItem;

public class PayItemDaoImpl extends HibernateDaoSupport implements PayItemDao {

	public void addPayItem(PayItem payItem) {
			this.getHibernateTemplate().save(payItem);
	}

	public List<PayItem> getPayItemByUid(String uid) {
			return (List<PayItem>) this.getHibernateTemplate().find("from PayItem where uid=?",uid);
	}

	public List<PayItem> getPayItemByPid(String pid) {
			return (List<PayItem>) this.getHibernateTemplate().find("from PayItem where pid=?",pid);
	}

	public List<PayItem> getPayItemByIid(String iid) {
			return (List<PayItem>) this.getHibernateTemplate().find("from PayItem where iid=?",iid);
	}

	public void updatePayItem(PayItem payItem) {
			this.getHibernateTemplate().update(payItem);
	}
	public PayItem getPayItemByPidAndUid(PayItem payItem) {
		List<PayItem> PayItems = (List<PayItem>) this.getHibernateTemplate().find("from PayItem where pid=? and uid=?",payItem.getPay().getPid(),payItem.getUser().getUid());
		if(PayItems!=null&&PayItems.size()>0) {
			return PayItems.get(0);
		}
		return null;
	}

}
