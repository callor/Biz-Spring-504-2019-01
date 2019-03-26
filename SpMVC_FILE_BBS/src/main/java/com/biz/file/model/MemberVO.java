package com.biz.file.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

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

@ScriptAssert(lang="javascript",
				message="비밀번호와 비밀번호 확인이 일치하지 않습니다",
				reportOn="m_re_password",
				script="(_this.m_password == _this.m_re_password)" )
public class MemberVO {
	
	/*
	 * VO 의 각 member변수들에 Constraint(제약조건)을 설정해서
	 * validation에서 사용할수 있도록 설정
	 * 
	 * @NotNull : null 아닌 경우만 정상
	 * @NotBlank : 문자열일 경우 공백이 아닐경우만 정상
	 * @Null : null 인 경우만 정상
	 * @Size(min=x, max=y) x 부터 y개수까지만 정상
	 * @Max(x) : x 값 이하일 경우만 정상
	 * @Min(y) : y 값 이상일 경우만 정상
	 * 
	 * @DecimalMax(x) : x 값 이하의 실수만 정상
	 * @DecimalMin(y) : y 값 이상의 실수만 정상
	 * @Digits(integer=x) : x 자릿수 이하의 정수
	 * @Digits(integer=x, fraction=y) : 
	 * 		x 자리숫의 정수와 y 자릿수 소수 이하의 숫자 
	 * 
	 */
	
	// constraints m_userid의 개수를
	// 문자열 3 부터 5개 범위까지만 입력하라
	@Size(min=3, max=30,message="* ID 는 3부터 30자리 까지")
	@NotBlank(message="* ID 는 공백이 올수 없습니다")
	@Email(message="* ID 는 Email 형식 이어야 합니다.")
	private String m_userid;
	
	// m_password는 null값이 올수 없다.
	// 반드시 입력하라
	@NotBlank(message="* 비밀번호를 입력하세요")
	private String m_password;
	
	private String m_re_password;
	
	@NotBlank(message="* 사용자 이름을 입력하세요")
	private String m_name;
	
	// 정규문법 검사하는 속성
	@Pattern(regexp = "\\d{1,15}",
			message="* 전화번호는 숫자 1부터 15자리까지만 가능")
	private String m_tel;
	
	
	

}
