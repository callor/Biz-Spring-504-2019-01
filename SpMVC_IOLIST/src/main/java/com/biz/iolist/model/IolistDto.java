package com.biz.iolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
/**
 * Dto class
 * Dto class와 VO class를 model class라고 한다.
 * model class 데이터를 담아서 옮기는 용도로 사용
 * domain class라고도 한다.
 * command class라고도 한다.
 * 
 * Dto와 VO는 역할이 거의 같은데 약간의 차이를 보면
 * VO는 DB Table과 보통 1:1로 매칭되는 구조
 * Dto는 화면(View)와 보통 1:1로 매칭되는 구조
 *
 */
public class IolistDto {

	private long io_id;
	private String io_date;
	private String io_time;
	private String io_pcode;
	private String p_name;
	
	private String io_dcode;
	private String d_name;
	private String d_ceo;
	private String d_tel;
	
	private String io_inout;
	private String io_tax;
	private int io_quan;
	private int io_price;
	
	// io_total(공급가액) 은 상품수량 * 공급단가
	private int io_total;
	
	// io_tax_total(공급대가) 은 
	// 과세일경우 공급가액 + VAT(공급가액의 10%)
	// 면세일경우 공급가액과 같다.
	private int io_tax_total;
	
}
