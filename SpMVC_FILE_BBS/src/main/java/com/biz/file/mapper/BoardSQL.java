package com.biz.file.mapper;

import org.apache.ibatis.jdbc.SQL;

public class BoardSQL {

	public String board_insert_sql() {
		
		SQL sql = new SQL()
				.INSERT_INTO("tbl_board")
				.INTO_COLUMNS("id").INTO_VALUES("#{id}")
				.INTO_COLUMNS("b_userid").INTO_VALUES("#{b_userid}")
				.INTO_COLUMNS("b_date").INTO_VALUES("#{b_date}")
				.INTO_COLUMNS("b_time").INTO_VALUES("#{b_time}")
				.INTO_COLUMNS("b_subject").INTO_VALUES("#{b_subject}")
				.INTO_COLUMNS("b_content").INTO_VALUES("#{b_content}")
				.INTO_COLUMNS("b_image").INTO_VALUES("#{b_image}")
				.INTO_COLUMNS("b_hit").INTO_VALUES("#{b_hit}");

		SQL sql1 = new SQL()
				.INSERT_INTO("tbl_board")
				.INTO_COLUMNS("id").INTO_VALUES("#{id}")
				.INTO_COLUMNS("b_userid,b_date,b_subject,b_content,b_hit")
				.INTO_VALUES("#{b_userid},#{b_date},#{b_subject},#{b_content},#{b_hit}");
				
		SQL sql2 = new SQL()
				.INSERT_INTO("tbl_board")
				.VALUES("id","#{id}")
				.VALUES("b_userid,b_date,b_subject,b_content,b_hit",
				"#{b_userid},#{b_date},#{b_subject},#{b_content},#{b_hit}");

		return sql.toString();
	}
	
	public String board_update_sql() {

			SQL sql = new SQL()
					.UPDATE("tbl_board")
					.SET("b_userid=#{b_userid}")
					.SET("b_date=#{b_date}")
					.SET("b_time=#{b_time}")
					.SET("b_subject=#{b_subject}")
					.SET("b_content=#{b_content}")
					.SET("b_image=#{b_image}")
					.SET("b_hit=#{b_hit}")
					.WHERE("id = #{id}");

			SQL sql1 = new SQL()
					.UPDATE("tbl_board")
					.SET("b_userid=#{b_userid},b_date=#{b_date}")
					.SET("b_subject=#{b_subject},b_content=#{b_context}")
					.SET("b_hit=#{b_hit}")
					.WHERE("id = #{id}");
					

			return sql.toString();
			
			
		
	}
	
}
