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

class MemberSQL {

	public String member_insert_sql() {
		
		/*
		 * VALUES 항목에 jdbcType=nVARCHAR
		 * 혹시 form에서 데이터를 입력하지 않더라도
		 * insert를 수행할때 SQL Exception을 내지 말라
		 * 단, TABLE에 PK, NOT NULL이 설정되지 않았을 경우
		 */
		SQL sql = new SQL()
				.INSERT_INTO("tbl_member")
				.INTO_COLUMNS("m_uesrid").INTO_VALUES("#{m_userid}")
				.INTO_COLUMNS("m_password").INTO_VALUES("#{m_password}")
				.INTO_COLUMNS("m_name").INTO_VALUES("#{m_name,jdbcType=nVARCHAR}")
				.INTO_COLUMNS("m_tel").INTO_VALUES("#{m_tel,jdbcType=nVARCHAR}");
		return sql.toString();
	}
	
	public String member_update_sql() {
		SQL sql = new SQL()
				.UPDATE("tbl_member")
				.SET("m_password = #{m_password}")
				.SET("m_name= #{m_name}")
				.SET("m_tel= #{m_tel}")
				.WHERE("m_userid = #{m_userid}");
		return sql.toString();
				
	}
	
}
