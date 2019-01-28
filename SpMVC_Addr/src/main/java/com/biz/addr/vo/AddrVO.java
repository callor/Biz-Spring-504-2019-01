package com.biz.addr.vo;

public class AddrVO {
	
	private String ad_num;
	private String ad_name;
	private String ad_tel;
	private String ad_addr1;
	private String ad_addr2;
	
	public AddrVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AddrVO(String ad_num, String ad_name, String ad_tel, String ad_addr1, String ad_addr2) {
		super();
		this.ad_num = ad_num;
		this.ad_name = ad_name;
		this.ad_tel = ad_tel;
		this.ad_addr1 = ad_addr1;
		this.ad_addr2 = ad_addr2;
	}



	public String getAd_num() {
		return ad_num;
	}
	public void setAd_num(String ad_num) {
		this.ad_num = ad_num;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_tel() {
		return ad_tel;
	}
	public void setAd_tel(String ad_tel) {
		this.ad_tel = ad_tel;
	}
	public String getAd_addr1() {
		return ad_addr1;
	}
	public void setAd_addr1(String ad_addr1) {
		this.ad_addr1 = ad_addr1;
	}
	public String getAd_addr2() {
		return ad_addr2;
	}
	public void setAd_addr2(String ad_addr2) {
		this.ad_addr2 = ad_addr2;
	}

	@Override
	public String toString() {
		return "AddrVO [ad_num=" + ad_num + ", ad_name=" + ad_name + ", ad_tel=" + ad_tel + ", ad_addr1=" + ad_addr1
				+ ", ad_addr2=" + ad_addr2 + "]";
	}
	
	

}
