package com.biz.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.email.mapper.MailDao;
import com.biz.email.model.MailVO;

@Service
public class MailService {
	
	@Autowired
	MailDao mDao;

	public int insert(MailVO mailVO) {
		return mDao.insert(mailVO);
	}

	public List<MailVO> selectAll() {
		return mDao.selectAll();
	}

	public MailVO findById(long id) {
		// TODO Auto-generated method stub
		return mDao.findById(id);
	}

	public int delete(long id) {
		// TODO Auto-generated method stub
		
		return mDao.delete(id);
		
	}

	public int update(MailVO mailVO) {
		// TODO Auto-generated method stub
		
		return mDao.update(mailVO);
	}
}
