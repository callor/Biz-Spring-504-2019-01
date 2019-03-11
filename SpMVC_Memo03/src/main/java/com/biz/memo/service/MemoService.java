package com.biz.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.mapper.MemoDao;
import com.biz.memo.model.MemoVO;

@Service
public class MemoService {

	@Autowired
	MemoDao dao;
	
	public int insert(MemoVO memoVO) {
		int ret = dao.insert(memoVO);
		return ret ;
	}

	public List<MemoVO> selectAll() {
		return dao.selectAll();
	}
	

	public MemoVO findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public int save(MemoVO memoVO) {

		int ret = 0;
		if(memoVO.getId() > 0) {
			ret = dao.update(memoVO);
		} else {
			ret = dao.insert(memoVO);
		}
		
		return 0;
	}

	public List<MemoVO> selectByUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.selectByUserId(userid);
	}

}
