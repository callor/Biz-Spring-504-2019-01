package com.biz.rent.mapper;

import org.apache.ibatis.jdbc.SQL;

public class UserSQL {

	public String user_insert_sql() {

		SQL sql = new SQL().INSERT_INTO("tbl_user")
				.INTO_COLUMNS("USER_SEQ").INTO_VALUES("SEQ_USER.NEXTVAL")
				.INTO_COLUMNS("USER_NAME").INTO_VALUES("#{user_name,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_BIRTH").INTO_VALUES("#{user_birth,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_SEX").INTO_VALUES("#{user_sex,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_PHONE").INTO_VALUES("#{user_phone,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_EMAIL").INTO_VALUES("#{user_email,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_IMAGE").INTO_VALUES("#{user_image,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_REG_DATE").INTO_VALUES("#{user_reg_date,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_OUT_DATE").INTO_VALUES("#{user_out_date,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_OUT_YN").INTO_VALUES("#{user_out_yn,jdbcType=VARCHAR}")
				.INTO_COLUMNS("USER_RENT_COUNT").INTO_VALUES("#{user_rent_count}")
				.INTO_COLUMNS("USER_RENT_TOTAL").INTO_VALUES("#{user_rent_total}");

		return sql.toString();
	}

	public String user_update_sql() {

		SQL sql = new SQL().UPDATE("tbl_user")
				.SET("USER_NAME = #{user_name,jdbcType=VARCHAR}")
				.SET("USER_BIRTH = #{user_birth,jdbcType=VARCHAR}")
				.SET("USER_SEX = #{user_sex,jdbcType=VARCHAR}")
				.SET("USER_PHONE = #{user_phone,jdbcType=VARCHAR}")
				.SET("USER_EMAIL = #{user_email,jdbcType=VARCHAR}")
				.SET("USER_IMAGE = #{user_image,jdbcType=VARCHAR}")
				.SET("USER_REG_DATE = #{user_reg_date,jdbcType=VARCHAR}")
				.SET("USER_OUT_DATE = #{user_out_date,jdbcType=VARCHAR}")
				.SET("USER_OUT_YN = #{user_out_yn,jdbcType=VARCHAR}")
				.SET("USER_RENT_COUNT = #{user_rent_count,jdbcType=INTEGER}")
				.SET("USER_RENT_TOTAL = #{user_rent_total,jdbcType=INTEGER}")
				.WHERE("USER_SEQ = #{user_seq}");

		return sql.toString();
	}

	
	
}
