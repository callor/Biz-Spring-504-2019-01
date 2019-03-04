package com.biz.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 데이터를 담아서 이동시킬때 사용할 클래스들
 * 		vo class
 * 		dto class
 * model 클래스
 * command 클래스
 * vo 클래스 
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuDto {
	
	String menu_id;
	String menu_title;
	String menu_href;

}
