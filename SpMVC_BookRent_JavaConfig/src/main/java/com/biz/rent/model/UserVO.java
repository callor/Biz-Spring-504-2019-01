package com.biz.rent.model;

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
public class UserVO {

	private long user_seq; 			//	number
	private String user_name; 		//	nvarchar2(100)
	private String user_birth; 		//	char(10)
	private String user_sex; 		//	char(1)
	private String user_phone; 		//	nvarchar2(100)
	private String user_email; 		//	nvarchar2(1000)
	private String user_image; 		//	nvarchar2(125)
	private String user_reg_date; 	//	char(10)
	private String user_out_date; 	//	char(10)
	private String user_out_yn; 	//	char(1)
	private long user_rent_count; 	//	number
	private long user_rent_total; 	//	number
	
}
