package com.biz.ajax.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.biz.ajax.model.ProductVO;

@Service
public class ProductService {
	String fileName = "product.txt";
	
	public List<ProductVO> getProduct() {

		// src/main/resources 폴더에 있는 fileName 정보를 가져와라
		ClassPathResource rs = new ClassPathResource(fileName);
		
		// FileReader 의 새로운 버전 1.8(1.7)이상에서 파일이나
		// 네트워크를 통해서 정보(내용)을 읽을때 사용하는 class
		InputStreamReader is; 
		BufferedReader buffer;
		
		try {
			is = new InputStreamReader(rs.getInputStream());
			buffer = new BufferedReader(is);
			String reader = "" ;
			List<ProductVO> iolist = new ArrayList<ProductVO>();
			
			while(true) {
				reader = buffer.readLine();
				if(reader == null) break;
				
				String[] inout = reader.split(":");

				ProductVO vo = new ProductVO();
				vo.setP_ccode(inout[0]);
				vo.setP_cname(inout[1]);
				vo.setP_vat(inout[2]);
				vo.setP_iprice(Integer.valueOf(inout[3]));
				vo.setP_oprice(Integer.valueOf(inout[4]));
				
				iolist.add(vo);
			
			}
			
			return iolist;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
