package com.community.service.impl;

import com.community.dao.WalletDao;
import com.community.domain.Wallet;
import com.community.service.WalletService;

public class WalletServiceImpl implements WalletService {
	private WalletDao walletDao;
	public void setWalletDao(WalletDao walletDao) {
		this.walletDao = walletDao;
	}
	public Wallet getUserWalletByUid(String uid) {
		return walletDao.getUserWalletByUid(uid);
	}

	public void updateUserWallet(Wallet wallet) {
		walletDao.updateUserWallet(wallet);
	}
	public void createWallet(Wallet wallet) {
		walletDao.createWallet(wallet);
	}

}
