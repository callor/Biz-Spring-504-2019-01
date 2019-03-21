package com.biz.file.model;

import javax.validation.constraints.Size;

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
	
	@Size(min=3, max = 5)
	private String m_userid;
	private String m_password;
	
	private String m_re_password;
	
	private String m_name;
	private String m_tel;

}
