package com.biz.memo.mapper;

public class MemoVO {
	
	private long id;
	private String subject;
	private String memo;
	
	public MemoVO(long id, String subject, String memo) {
		super();
		this.id = id;
		this.subject = subject;
		this.memo = memo;
	}
	public MemoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "MemoVO [id=" + id + ", subject=" + subject + ", memo=" + memo + "]";
	}
	
	

	
	
	
}
