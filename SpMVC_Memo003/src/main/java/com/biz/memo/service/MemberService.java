package com.biz.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.mapper.MemberDao;
import com.biz.memo.model.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	public List<MemberVO> findByUserId(MemberVO memberVO){
		return memberDao.findById(memberVO);
	}
	
	public int insert(MemberVO memberVO) {
		return memberDao.insert(memberVO);
	}
	
}
