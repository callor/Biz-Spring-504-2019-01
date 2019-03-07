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
public class MemberVO {

	private String m_userid;
	private String m_password;
	private String m_name;
	private String m_tel;
	
}
