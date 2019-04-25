package com.biz.bbs.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * tbl_bbs와 tbl_comment join한 
 * 결과를 담아서 이동할 VO
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BBsCommnetDto {

	private long id;
	private String b_auth;
	private String b_date;
	private String b_time;
	private String b_subject;
	private String b_text;
	private List<CommentVO> commentList ;
	
}
