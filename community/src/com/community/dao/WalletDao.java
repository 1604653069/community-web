package com.community.dao;

import com.community.domain.Wallet;

public interface WalletDao {

	public Wallet getUserWalletByUid(String uid);
	
	public void updateUserWallet(Wallet wallet);
	
	public void createWallet(Wallet wallet);
}
