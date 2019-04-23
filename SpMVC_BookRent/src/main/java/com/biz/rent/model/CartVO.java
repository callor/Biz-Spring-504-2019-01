package com.biz.rent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartVO {

	private String cart_date;
	private String cart_return_date;
	private long cart_book_seq;
	private String cart_book_title;
	
	private long cart_book_price;
	private long cart_user_seq;
	private String cart_user_name;
	
	private String cart_return_yn;
	
}
