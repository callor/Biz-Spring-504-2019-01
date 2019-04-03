package com.biz.iolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//p_code	CHAR(13)	PRIMARY KEY,
//p_name	nVARCHAR2(50)	NOT NULL,	
//p_tax	CHAR(1) DEFAULT '1',		
//p_iprice	NUMBER,		
//p_oprice	NUMBER		

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductVO {

	private String p_code;
	private String p_name;
	private String p_tax;
	private int p_iprice;
	private int p_oprice;
	
}
