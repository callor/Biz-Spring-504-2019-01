package com.biz.rent.mapper;

import org.apache.ibatis.jdbc.SQL;

//private int cart_seq;
//
//private String cart_date;
//private String cart_return_date;
//private long cart_book_seq;
//private String cart_book_title;
//
//private long cart_book_price;
//private long cart_user_seq;
//private String cart_user_name;
//
//private String cart_return_yn;


public class RentSQL {
	
	public String rent_insert_sql() {
		
		SQL sql = new SQL()
				.INSERT_INTO("tbl_rent")
		.INTO_COLUMNS("rent_seq").INTO_VALUES("SEQ_RENT.NEXTVAL")
		.INTO_COLUMNS("rent_date").INTO_VALUES("#{cart_date}")
		.INTO_COLUMNS("rent_return_date").INTO_VALUES("#{cart_return_date}")
		.INTO_COLUMNS("rent_book_seq").INTO_VALUES("#{cart_book_seq}")
		.INTO_COLUMNS("rent_user_seq").INTO_VALUES("#{cart_user_seq}")
		.INTO_COLUMNS("rent_return_yn").INTO_VALUES(" 'N' ");
		
		return sql.toString();
	
	}
	
	

}
