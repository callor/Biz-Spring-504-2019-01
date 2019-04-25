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
public class CommentVO {

	private long id;
	private long b_id;
	private String c_auth;
	private String c_date;
	private String c_time;
	private String c_text;

}
