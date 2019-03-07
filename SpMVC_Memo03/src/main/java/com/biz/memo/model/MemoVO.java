package com.biz.memo.model;

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
public class MemoVO {

	private long id;
	private String m_auth;
	private String m_date;
	private String m_subject;
	private String m_text;
	
}
