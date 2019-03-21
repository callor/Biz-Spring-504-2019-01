package com.biz.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import com.biz.file.model.MemberVO;

public interface MemberDao {
	
	@Select("SELECT * FROM tbl_member")
	public List<MemberVO> selectAll();
	
	@Select("SELECT * FROM tbl_member WHERE m_userid = #{m_userid} ")
	public MemberVO findByUserId(String m_userid);
	
	@InsertProvider(type=MemberSQL.class,method="member_insert_sql")
	public int insert(MemberVO memberVO);
	
	@UpdateProvider(type=MemberSQL.class,method="member_update_sql")
	public int update(MemberVO memberVO);
	
	@Delete("DELETE FROM tbl_member WHERE m_userid = #{m_userid}")
	public int delete(String m_userid);
	
}


