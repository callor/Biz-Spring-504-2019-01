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

}
