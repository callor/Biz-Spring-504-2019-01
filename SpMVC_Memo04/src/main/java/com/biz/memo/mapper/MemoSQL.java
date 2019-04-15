package com.biz.memo.mapper;

import org.apache.ibatis.jdbc.SQL;

public class MemoSQL {
	
	
	public String memo_insert_sql() {
		SQL sql = new SQL()
				.INSERT_INTO("tbl_line_memo")
				.INTO_COLUMNS("id").INTO_VALUES("#{id}")
				.INTO_COLUMNS("m_subject").INTO_VALUES("#{m_subject,jdbcType=VARCHAR}")
				.INTO_COLUMNS("m_memo").INTO_VALUES("#{m_memo,jdbcType=VARCHAR}");
		return sql.toString();
	}
	
	public String memo_update_sql() {
		SQL sql = new SQL()
				.UPDATE("tbl_line_memo")
				.SET("m_subject = #{m_subject,jdbcType=VARCHAR}")
				.SET("m_memo = #{m_memo,jdbcType=VARCHAR}")
				.WHERE("id=#{id}");
		return sql.toString();
		
	}

}
