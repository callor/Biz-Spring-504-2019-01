package com.biz.memo02.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data 대신 개별적으로 필요한 부분만 사용하는 방법
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CodeVO {

	private String label;	
	private String value;
	
	
	
}
