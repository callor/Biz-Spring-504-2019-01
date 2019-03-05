package com.biz.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.memo.model.MemberVO;

public interface MemberDao {

	@InsertProvider(type=MemberSQL.class,method="member_insert_sql")
	public int insert(MemberVO memberVO);
	
	// login 창에서 m_userid와 m_password를 POST로 넘기면
	// MemberVO에 받고,
	// MemberVO의 m_userid로 조회를 해서 
	// List<MemberVO>를 return 받고
	// service에서 비밀번호를 조회해서 
	// 정상적으로 login이 되었나를 확인한다.
	@Select(" SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ")
	public List<MemberVO> findById(MemberVO memberVO);
		
	// 회원정보 수정, 삭제, 부분은 차후에 작성
	
}
