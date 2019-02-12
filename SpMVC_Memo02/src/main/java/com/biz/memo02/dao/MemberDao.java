package com.biz.memo02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.memo02.vo.MemberVO;

public interface MemberDao {
	
	@Select(" SELECT * FROM tbl_member ")
	public List<MemberVO> selectAll();
	
	@Select(" SELECT * FROM tbl_member WHERE id = #{id} ")
	public MemberVO findById(long id);
	
	@Select(" SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ")
	public MemberVO findByUserId(String m_userid);
	
	// 아이디와 비번을 매개변수로 받아서
	// 로그인 정보를 조회하는 method
	@Select(MemberSQL.MEMBER_USER_CHECK)
	public MemberVO userCheck(MemberVO vo);
		
	@Insert(MemberSQL.MEMBER_INSERT)
	public int insert(MemberVO vo);
	
	@Update(MemberSQL.MEMBER_UPDATE)
	public int update(MemberVO vo);
	
	@Delete(" DELETE FROM tbl_member WHERE id= #{id} ")
	public int delete(long id);
	
}
