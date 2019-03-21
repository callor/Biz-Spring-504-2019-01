package com.biz.file.service;

import java.util.List;

import com.biz.file.model.MemberVO;

public interface MemberService {
	
	public List<MemberVO> selectAll();
	public MemberVO findByUserId(String m_userid);
	public int insert(MemberVO memberVO);
	public int update(MemberVO memberVO);
	public int delete(String m_userid);

}
