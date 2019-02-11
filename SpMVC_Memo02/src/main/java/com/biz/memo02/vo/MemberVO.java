package com.biz.memo02.vo;

/*
 * 회원가입을 위한 VO를 생성
 */
public class MemberVO {

	private long id ;
	
	private String m_userid ;
	private String m_password ;
	private String m_name;
	private String m_tel;
	private String m_city;
	private String m_addr ;
	private String m_hobby;
	
		
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(long id, String m_userid, String m_password, String m_name, String m_tel, String m_city,
			String m_addr, String m_hobby) {
		super();
		this.id = id;
		this.m_userid = m_userid;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_tel = m_tel;
		this.m_city = m_city;
		this.m_addr = m_addr;
		this.m_hobby = m_hobby;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getM_userid() {
		return m_userid;
	}



	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}



	public String getM_password() {
		return m_password;
	}



	public void setM_password(String m_password) {
		this.m_password = m_password;
	}



	public String getM_name() {
		return m_name;
	}



	public void setM_name(String m_name) {
		this.m_name = m_name;
	}



	public String getM_tel() {
		return m_tel;
	}



	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}



	public String getM_city() {
		return m_city;
	}



	public void setM_city(String m_city) {
		this.m_city = m_city;
	}



	public String getM_addr() {
		return m_addr;
	}



	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}



	public String getM_hobby() {
		return m_hobby;
	}



	public void setM_hobby(String m_hobby) {
		this.m_hobby = m_hobby;
	}



	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", m_userid=" + m_userid + ", m_password=" + m_password + ", m_name=" + m_name
				+ ", m_tel=" + m_tel + ", m_city=" + m_city + ", m_addr=" + m_addr + ", m_hobby=" + m_hobby + "]";
	}

	
	

	
	
	
}
