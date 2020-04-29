package com.community.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.community.dao.SSDao;
import com.community.domain.SS;
import com.community.service.SSService;
@Transactional
public class SSServiceImpl implements SSService {

	private SSDao ssDao;
	public void setSsDao(SSDao ssDao) {
		this.ssDao = ssDao;
	}

	public List<SS> findAllSS() {
		return ssDao.findAllSS();
	}

	public void addSS(SS ss) {
		ssDao.addSS(ss);
	}

	public void removeSS(String sid) {
		ssDao.removeSS(sid);
	}

	public SS getSSBySid(String sid) {
		return ssDao.getSSBySid(sid);
	}

	public void removeSS(SS ss) {
		ssDao.removeSS(ss);
	}

	public List<SS> getUserSSByUid(String uid) {
		return ssDao.getUserSSByUid(uid);
	}

}
