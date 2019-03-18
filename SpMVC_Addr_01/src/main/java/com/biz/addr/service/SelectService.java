package com.biz.addr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.addr.model.SelectVO;

@Service
public class SelectService {

	
	
	public List<String> getCities2() {
		
		List<String> cities = new ArrayList<String>();
		cities.add("서울특별시");
		cities.add("광주광역시");
		cities.add("부산광역시");
		cities.add("인천광역시");
		cities.add("대전광역시");
		cities.add("제주특별자치도");
		
		return cities;
	}
	
	public List<SelectVO> getCities() {
		
		List<SelectVO> cities = new ArrayList<SelectVO>();
		
		SelectVO svo = SelectVO.builder()
				.label("서울특별시")
				.value("SEOUL").build();
		
		cities.add(svo);
		
		svo = SelectVO.builder()
				.label("광주광역시")
				.value("GW").build();
		
		cities.add(svo);
		cities.add(SelectVO.builder()
				.label("부산광역시")
				.value("BUSAN").build());
		
		cities.add(SelectVO.builder()
				.label("대전광역시")
				.value("DAEJUN").build());
		
		cities.add(SelectVO.builder()
				.label("인천광역시")
				.value("INCHUN").build());
		
		cities.add(SelectVO.builder()
				.label("제주특별자치도")
				.value("JEJU").build());

		
		return cities;
	}
	
}
