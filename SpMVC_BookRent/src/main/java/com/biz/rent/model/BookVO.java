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
public class BookVO {

	private long book_seq; 			//	number
	private String book_isbn;		//	char(13)
	private String book_title;		//	nvarchar2(100)
	private String book_author;		//	nvarchar2(100)
	private long book_price;		//	number
	private String book_description;//	nvarchar2(1000)
	private String book_image;		//	nvarchar2(125)
	private String book_link;		//	nvarchar2(255)
	private String book_rent_yn;	//	char(1)
	
}
