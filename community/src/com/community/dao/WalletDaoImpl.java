package com.community.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.community.domain.Wallet;
@Transactional
public class WalletDaoImpl extends HibernateDaoSupport implements WalletDao {
	public Wallet getUserWalletByUid(String uid) {
		List<Wallet> wallets = (List<Wallet>) this.getHibernateTemplate().find("from Wallet where uid=?", uid);
		if(wallets!=null&&wallets.size()>0) {
			return wallets.get(0);
		}else 
			return null;
	}
	public void updateUserWallet(Wallet wallet) {
			this.getHibernateTemplate().update(wallet);
	}

	public void createWallet(Wallet wallet) {
			this.getHibernateTemplate().save(wallet);
	}

}
