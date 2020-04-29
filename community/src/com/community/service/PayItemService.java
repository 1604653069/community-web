package com.community.service;

import java.util.List;

import com.community.domain.PayItem;

public interface PayItemService {

public void addPayItem(PayItem payItem);
	
	public List<PayItem> getPayItemByUid(String uid);
	
	public List<PayItem> getPayItemByPid(String pid);
	
	public List<PayItem> getPayItemByIid(String iid);
	
	public void updatePayItem(PayItem payItem);
	public PayItem getPayItemByPidAndUid(PayItem payItem);
}
