package com.biz.file.model;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

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
public class MemberVO {
	
	/*
	 * VO 의 각 member변수들에 Constraint(제약조건)을 설정해서
	 * validation에서 사용할수 있도록 설정
	 * 
	 * @Null : 반드시 입력해야하는 값이다
	 * @NotNull : 값이 널이 아닌가?
	 * @Size(min=x, max=y) : 문자열일 경우 x부터 y까지 범위의 개수
	 * @Max : 숫자형일경우 지정한 값보다 작은 값만 허용
	 * @Mix : 지정한 값보다 큰값만 허용
	 * 
	 * @AssetTrue : boolean 형일겅우 참인가? , 조건이 참인가?
	 * @AssetFalse : boolean 형일겅우 참인가?, 조건이 거짓인가?
	 * 
	 * @DecialMax : 지정한 값 이하 실수인가
	 * @DecailMix : 지정한 값 이상 실수인가
	 * @Digits(integer) : 정수인가
	 */
	
	// constraints m_userid의 개수를
	// 문자열 3 부터 5개 범위까지만 입력하라
	@Size(min=3, max = 15,message="UserID는 3부터 5까지")
	private String m_userid;
	
	// m_password는 null값이 올수 없다.
	// 반드시 입력하라
	@Null(message="비밀번호를 입력하세요")
	private String m_password;
	
	private String m_re_password;
	
	private String m_name;
	private String m_tel;
	
	
	

}
