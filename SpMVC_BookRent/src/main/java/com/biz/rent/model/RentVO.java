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
public class RentVO {

	private long rent_seq;
	private String rent_date;
	private String rent_return_date;
	private long rent_book_seq;
	private long rent_user_seq;
	private String rent_return_yn;
	
}
