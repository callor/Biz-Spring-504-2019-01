package com.biz.memo02.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 
 * 회원가입을 위한 VO를 생성
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberVO {

	private long id ;
	private String m_userid ;
	private String m_password ;
	private String m_re_password ;
	
	private String m_name;
	private String m_tel;
	private String m_city;
	private String m_addr ;
	private String[] m_hobby;
	
}
