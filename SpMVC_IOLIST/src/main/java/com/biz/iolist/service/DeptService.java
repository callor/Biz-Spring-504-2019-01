package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.biz.iolist.mapper.DeptDao;
import com.biz.iolist.model.DeptVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeptService {

	@Autowired
	SqlSession session;
	
	public List<DeptVO> selectAll(){
		
		log.debug("DeptService Call");
		DeptDao dDao = session.getMapper(DeptDao.class);
		List<DeptVO> deptVO = dDao.selectAll();
		return deptVO;

	}

	public int insert(DeptVO deptVO) {
		// TODO Service insert 메서드
		
		// TODO Service insert 테스트케이스
		// 조건 : session으로부터 DeptDao mapper를 추출
		// 결과 : deptDao mapper의 insert를 수행하여
		//		테이블에 데이터 저장 완료
		DeptDao dDao = session.getMapper(DeptDao.class);
		int ret = dDao.insert(deptVO);
		return ret;
	}
}







