package com.biz.file.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.file.model.MemberVO;

@Service
public class MemberSerivceImp implements MemberService {

	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByUserId(String m_userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String m_userid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
