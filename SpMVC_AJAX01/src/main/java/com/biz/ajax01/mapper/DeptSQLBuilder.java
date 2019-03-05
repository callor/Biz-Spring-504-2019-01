
package com.biz.ajax01.mapper;

// 2015년 이후 mybatis에서 사용가능한 클래스
// 실무에서 사용예를 못봤다.
import org.apache.ibatis.jdbc.SQL;

public class DeptSQLBuilder {

	// SQL 클래스는 Mybatis 3.1에서 도입
	public String getSelectAllSQL() {
		// C# LINQ
		SQL sql = new SQL()
				.SELECT("*")
				.FROM("tbl_dept")
				.ORDER_BY("d_code");
		
		return sql.toString();
	}
	
	public String getInsertSQL() {
		// SQLBuilder(Mybatis 3.4에서 새로 도입된
		// SQL 작성기의 초기버전
		// 1.7이하에서 컴파일 오류가 가능성
		SQL sql = new SQL();
		
			sql.INSERT_INTO("tbl_dept");
			sql.INTO_COLUMNS("d_code");
			sql.INTO_VALUES("#{d_code,jdbcType=VARCHAR}");
				
			sql.VALUES("d_name","#{d_name,jdbcType=NVARCHAR}");
			sql.VALUES("d_ceo","#{d_ceo,jdbcType=NVARCHAR}");

		return sql.toString();
		
	}
	
	public String getUpdateSQL() {
		SQL sql = new SQL()
				.UPDATE("tbl_dept")
				.SET("d_code = #{d_code,jdbcType=VARCHAR}")
				.SET("d_name = #{d_name,jdbcType=NVARCHAR}")
				.SET("d_ceo = #{d_ceo,jdbcType=NVARCHAR}")
				.WHERE("d_code = #{d_code,jdbcType=NVARCHAR}");
		
		return sql.toString();
	}
	
	public String getDeleteSQL() {
		SQL sql = new SQL()
				.DELETE_FROM("tbl_dept")
				.WHERE("d_code = #{d_code}");
		return sql.toString();
	}
	
}
