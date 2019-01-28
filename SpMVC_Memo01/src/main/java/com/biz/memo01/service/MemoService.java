package com.biz.memo01.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo01.model.MemoDao;
import com.biz.memo01.model.MemoVO;

@Service
public class MemoService {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	MemoDao memoMapper;
	
	public int insert(MemoVO vo) {
		
//		MemoDao dao = sqlSession.getMapper(MemoDao.class);
//		int ret = dao.insert(vo);
//		sqlSession.commit();
		int ret = memoMapper.insert(vo);
		return ret;

	}
	
}
