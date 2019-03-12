package com.biz.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder // Builder 패턴을 사용하기 위한 설정
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileVO {

	private long id;
	private long parent_id; // tbl_memo와 FK 관계
	private String file_name;
	private String save_file_name;
	
}
