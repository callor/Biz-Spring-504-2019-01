package com.biz.bbs.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BBsDao;
import com.biz.bbs.model.BBsVO;

@Service
public class BBsService {
	
	/*
	 * mybatis-context.xml에 설정된
	 * SqlSessionTemplte를 사용하기 위한 Autowired
	 */
	@Autowired
	private SqlSession sqlSession;
	
	public List<BBsVO> selecAll() {
		
		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		List<BBsVO> bbsList = bDao.selectAll();
		return bbsList;
		
	}
	
	public List<BBsVO> pageList(long page_no) {
		
		long start = (page_no-1) * 10;
		long end = start + 10;
		
		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		List<BBsVO> bbsList = bDao.pageSelect(start, end);
		
		return bbsList;
		
	}

	public int insert(BBsVO bbsVO) {

		//textarea에 입력할때 Enter를 추가해서 줄바꿈을 했을 경우
		// 줄바꿈 특수문자를 br tag로 변경하는 코드
		String s_content = bbsVO
						.getB_content()
						.replaceAll("\r\n|\r|\n|\n\r", "<br />");
		// bbsVO.setB_content(s_content);

		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		int ret = bDao.insert(bbsVO);
		
		return ret;
	}

	public BBsVO findById(long id) {

		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		BBsVO bbsVO = bDao.findById(id);
		return bbsVO;
	
	}

	public int delete(long id) {

		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		int ret = bDao.delete(id);
		return 0;
	}

	public int update(BBsVO bbsVO) {
		// 
		BBsDao bDao = sqlSession.getMapper(BBsDao.class);
		int ret = bDao.update(bbsVO);
		return ret;
	}
	

}
