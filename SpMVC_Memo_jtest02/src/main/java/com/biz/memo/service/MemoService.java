package com.biz.memo.service;

import org.springframework.stereotype.Service;

import com.biz.memo.model.MemoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemoService {

	public MemoVO findById(long id) {
		
		MemoVO vo = new MemoVO();
		vo.setId(1);
		vo.setDate("2019-04-17");
		vo.setSubject("오늘은 수요일");
		vo.setMemo("메모하기 좋은날");
		
		log.debug("LOG");
		log.debug("MEMOVO : " + vo.toString() );
		
		return vo;
	}
}
