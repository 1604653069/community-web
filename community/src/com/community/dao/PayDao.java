package com.community.dao;

import java.util.List;

import com.community.domain.Pay;

public interface PayDao {

	public List<Pay> getAllPays();
	
	public Pay getPayByPid(String pid);
	
	public void addPay(Pay pay);
	
	public void update(Pay pay);

	public void remove(Pay pay);
}
