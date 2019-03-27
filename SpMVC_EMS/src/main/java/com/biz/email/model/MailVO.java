package com.biz.email.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//id NUMBER PRIMARY KEY,
//from_email nVARCHAR2(30),
//to_email nVARCHAR2(30),
//s_date nVARCHAR2(10),
//s_time nVARCHAR2(10),
//s_subject nVARCHAR2(125),
//s_content nVARCHAR2(2000),
//s_file1 nVARCHAR2(125),
//s_file2 nVARCHAR2(125)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MailVO {

	private long id;
    private String from_email ;
    private String to_email;
    private String s_date;
    private String s_time;
    private String s_subject;
    private String s_content;
    private String s_file1;
    private String s_file2;
	
}
