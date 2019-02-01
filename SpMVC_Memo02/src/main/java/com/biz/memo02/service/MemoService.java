package com.biz.memo02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo02.dao.MemoDao;
import com.biz.memo02.vo.MemoVO;

@Service
public class MemoService {

	@Autowired // == @Inject
	MemoDao memoMapper;
	
	/*
	 * TDD(Test Driven Developer)
	 * 	1. MemoService 클래스의 어떤 메서드를 호출해서 사용할 곳에서
	 * 		먼저 method 사용(호출) 코드를 작성
	 *  2. 당연히 문법 오류가 날 것이므로
	 *  3. 이클립스의 도움을 받아서
	 *  4. create method를 실행한다.
	 *  5. 이클립스는 MemoService 클래스에 자동으로 매개변수와
	 *  	리턴값 까지 설정하여
	 *  	메서드를 작성 해 준다.
	 * 
	 */
	public int insertDB(MemoVO vo) {
		// 매개변수로 받은 vo를 일단 아무런 가공 없이
		// MemoDao를 통해서 DB에 저장을 실행하자.

		// MemoDao의 insert가 정상적으로 실행되면
		// 0 보다 큰 값이 리턴 될 것이고
		// 그 리턴값을 Controller 에게 다시 리턴한다
		int ret = memoMapper.insert(vo);
		return ret;
	}

	public List<MemoVO> selectAll() {

		List<MemoVO> memoList = memoMapper.selectAll();
		return memoList;
	
	}

}
