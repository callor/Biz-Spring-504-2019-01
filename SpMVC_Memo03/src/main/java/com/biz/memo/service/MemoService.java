package com.biz.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.mapper.MemoDao;
import com.biz.memo.model.MemoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	/*
	 * 
	 * memoVO의 id 값을 검사해서
	 * 0보다 크면 수정(Update)
	 * 그렇지 않으면 추가(Insert)
	 * 
	 */
	public int save(MemoVO memoVO) {

		int ret = 0;
		if(memoVO.getId() > 0) {
			ret = dao.update(memoVO);
		} else {
			log.debug("Before Insert MemoID : " + memoVO.getId());
			ret = dao.insert(memoVO);
			log.debug("After Insert MemoID : " + memoVO.getId());
		}
		return 0;
	}

	public List<MemoVO> selectByUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.selectByUserId(userid);
	}

	public int delete(long id) {
		return dao.delete(id);
	}
}
