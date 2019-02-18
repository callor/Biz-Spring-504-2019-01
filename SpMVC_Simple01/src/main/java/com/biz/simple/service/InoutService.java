package com.biz.simple.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.biz.simple.vo.InoutVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InoutService {
	
	String fileName = "inout.txt";
	
	/*
	 * inout.txt 파일을 읽어서
	 * 각 라인을 splite으로 분해한후
	 * 항목별로 vo에 담고,
	 * List<InoutVO>에 추가해서
	 * 상품매입매출 List를 생성
	 */
	public List<InoutVO> getInout() {

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
			List<InoutVO> iolist = new ArrayList<InoutVO>();
			
			while(true) {
				reader = buffer.readLine();
				if(reader == null) break;
				
				String[] inout = reader.split(":");

				// date       time     cname      c p   s
				// 2018-01-02:00:07:31:그린타임캔:2:700:87
				// splite으로 나누었을때
				// 0          1  2  3  4          5 6   7
				// time = 1 + 2 + 3
				InoutVO vo = new InoutVO();
				vo.setIo_date(inout[0]);
				vo.setIo_time(inout[1] + ":" + inout[2] + ":" + inout[3]);
				vo.setIo_cname(inout[4]);
				vo.setIo_check(inout[5]);
				vo.setIo_price(Integer.valueOf(inout[6]));
				vo.setIo_su(Integer.valueOf(inout[7]));
				
				iolist.add(vo);
			}
			
			return iolist;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 1.8 이상에서만 사용가능 코드
	 */
	public List<InoutVO> getIolist() {
		
		ClassPathResource rs = new ClassPathResource(fileName);

		// Resource 정보에서 인터넷 주소개념의 file 정보를 추출
		Path path ; 
		try {
			
			 path = Paths.get(rs.getURI());
			 List<String> lines = Files.readAllLines(path);

			 List<InoutVO> iolist = new ArrayList<InoutVO>();
			 for(String line : lines) {
					String[] inout = line.split(":");

					// date       time     cname      c p   s
					// 2018-01-02:00:07:31:그린타임캔:2:700:87
					// splite으로 나누었을때
					// 0          1  2  3  4          5 6   7
					// time = 1 + 2 + 3
					InoutVO vo = new InoutVO();
					vo.setIo_date(inout[0]);
					vo.setIo_time(inout[1] + ":" + inout[2] + ":" + inout[3]);
					vo.setIo_cname(inout[4]);
					vo.setIo_check(inout[5]);
					vo.setIo_price(Integer.valueOf(inout[6]));
					vo.setIo_su(Integer.valueOf(inout[7]));
					iolist.add(vo);
			 }
			 
			 
			 for(InoutVO vo : iolist) {
				 log.debug(vo.toString());
			 }
			 
			 // 1.8 버전용 for
			 lines.forEach(log::debug);
			 for(String line : lines) {log.debug(line);} ;
			 
			 return iolist;
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}



