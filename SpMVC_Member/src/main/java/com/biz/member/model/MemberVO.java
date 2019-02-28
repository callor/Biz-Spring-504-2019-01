package com.biz.member.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
	private String m_userid;
	private String m_password;
	private String m_name;
	private String m_tel;
	private String m_city;
	private String m_addr;
	private String m_photo;
	private String m_photo_path;
	
	private String m_role;

}
