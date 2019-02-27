package com.biz.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.member.mapper.MemberDao;
import com.biz.member.model.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDao dao;

	public void insert(MemberVO memberVO) {
		dao.insert(memberVO);
	}

	public MemberVO findById(String m_userid) {
		// TODO Auto-generated method stub
		return dao.findById(m_userid);
	}

	public List<MemberVO> loginCheck(String userid) {

		List<MemberVO> mList = dao.loginCheck(userid);
		return mList;
	
	}
}
