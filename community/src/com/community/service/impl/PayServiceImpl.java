package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.PayDao;
import com.community.domain.Pay;
import com.community.service.PayService;
@Transactional
public class PayServiceImpl implements PayService {

	private PayDao payDao;
	public void setPayDao(PayDao payDao) {
		this.payDao = payDao;
	}
	public List<Pay> getAllPays() {
		return payDao.getAllPays();
	}

	public Pay getPayByPid(String pid) {
		return payDao.getPayByPid(pid);
	}

	public void addPay(Pay pay) {
			payDao.addPay(pay);
	}

	public void update(Pay pay) {
			payDao.update(pay);
	}
	public void remove(Pay pay) {
			payDao.remove(pay);
	}

}
