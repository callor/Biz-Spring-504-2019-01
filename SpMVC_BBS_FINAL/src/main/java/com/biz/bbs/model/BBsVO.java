package com.biz.bbs.model;

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
public class BBsVO {

	private long id;
	private String b_auth;
	private String 	b_date;
	private String b_time;
	private String b_subject;
	private String b_text;
	
}
