package com.community.service;

import com.community.domain.Wallet;

public interface WalletService {
	
	public Wallet getUserWalletByUid(String uid);
	
	public void updateUserWallet(Wallet wallet);

	public void createWallet(Wallet wallet);
}
