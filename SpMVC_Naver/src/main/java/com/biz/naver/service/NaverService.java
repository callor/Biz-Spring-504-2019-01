package com.biz.naver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.biz.naver.config.NaverClient;

@Service
public class NaverService {

	// 도서정보 검색
	public void getBookInfo() {

		// id와 key
		String clientId = NaverClient.ID ;
		String clientKey = NaverClient.KEY;
		
		// 검색문자열을 하나 선언
		String text = "자바";
		
		try {
			// 검색문자열을 Naver로 보내기전에 Encoding을 실시
			text = URLEncoder.encode(text,"UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/book.json" ;
			apiURL += "?query=" + text;
			
			// URL 객체로 생성
			URL url  = new URL(apiURL);
			
			// HttpRequest로 변환
			HttpURLConnection conn 
			= (HttpURLConnection) url.openConnection();
			
			// 접속정보를 Setting
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", clientId);
			conn.setRequestProperty("X-Naver-Client-Secret", clientKey);

			// 네이버에게 요청보내서
			// 내 요청에 응답할수 있느냐 라고 묻기
			int resCode = conn.getResponseCode();
			
			BufferedReader buffer ;
			if(resCode == 200) {
				// 데이터를 수신할 준비
				InputStreamReader is 
				= new InputStreamReader(conn.getInputStream());
				
				buffer = new BufferedReader(is);
			} else {
				// 오류가 무엇인지 분석
				InputStreamReader is 
				= new InputStreamReader(conn.getErrorStream());
				buffer = new BufferedReader(is);
			}
			
			String reader = "";
			while(true) {
				reader = buffer.readLine();
				if(reader == null) break;
				System.out.print(reader);
			}
			
			buffer.close();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
