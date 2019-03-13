package com.biz.memo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * spring에서 model 객체들은
 * spring의 확장 기능을 거의 사용하지 않는 클래스 들이다
 * (단, lombok을 사용하지 않을 경우)
 * 기본적으로 자바 자료형의 member 변수를 갖고
 * getter, setter, 생성자, toString 메서드를 갖고 있다.
 * 그래서 이러한 클래스들을 Plan Old Java Object 라고 부른다.
 * 
 * model 패키지를 부르는 용어로
 * spring 이전에는 단순히 vo, dto로 불리었고
 * spring MVC 패턴에서는 model(클래스들)이라고 한다.
 * 
 * 프로그래밍 그룹이나, 단체, 회사마다 조금씩 다른 용어도 사용하는데
 * 
 * DB관점에서 바라볼때는 Domain 객체(클래스)라고 하고
 * form(입력form)의 관점에서 바라볼때는 Command 객체(클래스)라고도 한다.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemoVO {

	private long id;
	private String m_auth;
	private String m_date;
	private String m_subject;
	private String m_text;
	
	// tbl_files 데이터를 가져와서 저장할 변수
	private List<FileVO> files; 
	
}
