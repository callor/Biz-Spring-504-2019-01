package com.biz.memo.mapper;

import org.apache.ibatis.jdbc.SQL;

public class FileSQL {

	public String file_insert_sql() {
		
		SQL sql = new SQL()
			.INSERT_INTO("tbl_files")
			.INTO_COLUMNS("id").INTO_VALUES("SEQ_FILE.NEXTVAL")
			.INTO_COLUMNS("parent_id").INTO_VALUES("#{parent_id}")
			.INTO_COLUMNS("file_name").INTO_VALUES("#{file_name}")
			.INTO_COLUMNS("save_file_name").INTO_VALUES("#{save_file_name}");
		
		return sql.toString();
		
	}
	
	
}
