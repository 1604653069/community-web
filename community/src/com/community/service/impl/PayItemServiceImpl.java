package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.PayItemDao;
import com.community.domain.Pay;
import com.community.domain.PayItem;
import com.community.service.PayItemService;
import com.community.service.PayService;

@Transactional
public class PayItemServiceImpl implements PayItemService {
	private PayItemDao payItemDao;
	public void setPayItemDao(PayItemDao payItemDao) {
		this.payItemDao = payItemDao;
	}
	public void addPayItem(PayItem payItem) {
		payItemDao.addPayItem(payItem);
	}
	public List<PayItem> getPayItemByUid(String uid) {
		return payItemDao.getPayItemByUid(uid);
	}
	public List<PayItem> getPayItemByPid(String pid) {
		return payItemDao.getPayItemByPid(pid);
	}
	public List<PayItem> getPayItemByIid(String iid) {
		return payItemDao.getPayItemByIid(iid);
	}
	public void updatePayItem(PayItem payItem) {
		payItemDao.updatePayItem(payItem);
	}
	public PayItem getPayItemByPidAndUid(PayItem payItem) {
		return payItemDao.getPayItemByPidAndUid(payItem);
	}


}
