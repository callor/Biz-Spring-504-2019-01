package com.biz.memo01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo01.model.MemoDao;
import com.biz.memo01.model.MemoVO;

@Service
public class MemoService {

//	@Autowired
//	SqlSession sqlSession;
	
	@Autowired
	MemoDao memoMapper;
	
	// MemoDao의 selectAll() 메서드를 호출해서
	// SELECT SQL을 실행한 다음
	// 결과를 memoList에 받고
	// 아무런 가공 없이 Controller로 return
	public List<MemoVO> selectAll() {
		List<MemoVO> memoList = memoMapper.selectAll();
		return memoList;
	}
	
	public int insert(MemoVO vo) {
		
//		MemoDao dao = sqlSession.getMapper(MemoDao.class);
//		int ret = dao.insert(vo);
//		sqlSession.commit();
		
		int ret = memoMapper.insert(vo);
		return ret;
	}

	public MemoVO findById(long id) {
		// TODO Auto-generated method stub
		MemoVO vo = memoMapper.findById(id);
		return vo;
	}

	public int delete(Long id) {
		return memoMapper.delete(id);
	}

	public void memo_write(MemoVO vo) {

		// vo에는 form에서 보내온 데이터가 담겨 있다.
		// vo member 변수중에서
		// 없는 값이 있다. == id가 없는 상태
		
		// 새로 메모를 작성하기 했을 경우 id 값이 아마도 0 일것이다.
		// 메모를 수정하기로 했을 경우는 id 값이 0 이 이외 일것이다.
		
		if(vo.getId()>0) {
			memoMapper.update(vo);
		} else {
			memoMapper.insert(vo);
		}
		
		
		
	}
	
}
