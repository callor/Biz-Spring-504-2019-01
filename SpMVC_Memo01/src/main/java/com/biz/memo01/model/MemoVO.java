package com.biz.memo01.model;

public class MemoVO {
	
	private long id;
	private String m_auth;
	private String m_date;
	private String m_subject;
	private String m_text;
	
	
	public MemoVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public MemoVO(long id, String m_auth, String m_date, String m_subject, String m_text) {
		super();
		this.id = id;
		this.m_auth = m_auth;
		this.m_date = m_date;
		this.m_subject = m_subject;
		this.m_text = m_text;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getM_auth() {
		return m_auth;
	}


	public void setM_auth(String m_auth) {
		this.m_auth = m_auth;
	}



	public String getM_date() {
		return m_date;
	}



	public void setM_date(String m_date) {
		this.m_date = m_date;
	}



	public String getM_subject() {
		return m_subject;
	}



	public void setM_subject(String m_subject) {
		this.m_subject = m_subject;
	}



	public String getM_text() {
		return m_text;
	}



	public void setM_text(String m_text) {
		this.m_text = m_text;
	}




	@Override
	public String toString() {
		return "MemoVO [id=" + id + ", m_auth=" + m_auth + ", m_date=" + m_date + ", m_subject=" + m_subject
				+ ", m_text=" + m_text + "]";
	}



	

}
