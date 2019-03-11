package com.biz.memo.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.memo.model.MemoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileService {
	
	@Autowired
	ServletContext context;
	
	
	public int fileSave(String fileName) {
		
		return 0;
	}
	
	
	public String fileUpload(MemoVO memoVO, 
				MultipartFile m_file) {
		
		// 업로드할 원래 파일 이름을 추출
		String fileName = m_file.getOriginalFilename();
		String saveFileName = "";
		
		// tomcat server가 실행해서
		// 보여주는 context root가 어디냐
		String realPath = context.getRealPath("/");
		String upLoadPath = realPath + "files/";
		log.debug("realPath: " + realPath);
		log.debug("upLoadPath: " + upLoadPath);
		
		if(m_file != null) {
			
			// 혹시 지정된 크기보다 큰 파일이 업로드 되면
			// 무시 해 버리자.
			if(m_file.getSize() > 1048576) {
				return null ;
			}
			
			// 파일이름을 검사해서 null이 아니고, "" 아닌경우만
			// 처리 하겠다.
			if(fileName != null && !fileName.equals("")) {
				
				/*
				 * UUID : universally Unique Identified
				 * 범용 유일 식별자
				 * 유일한 단독 키값 
				 * 16진수 32자리의 임의 키값을 생성
				 * 16의 32승 만큼 임의 값중 하나 생성
				 * 340,282,366,920,938,463,463,374,607,431,768,211,456
				 * 
				 * 오리지널 파일 이름으로 업로드를 하면
				 * 혹시 악의적인 사용자에 의해서 파일이 변조 될수 있으므로
				 * 업로드할때는 임의 키값을 생성해서 업로들 수행한다.
				 * 
				 * UUID는 자바5(1.5)부터 사용가능하고
				 * 그전에는 timestampe
				 * 
				 */
				saveFileName 
					= UUID.randomUUID().toString() + fileName ;
				
				File dir = new File(upLoadPath);
				if(!dir.exists()) { // 폴더가 자동으로 생성되지 않았으면
					dir.mkdir() ; // 폴더를 만들어라
				}
				
				// 운영체제 독립적인 구조의 파일 이름 체계를 생성
				File upLoadFile 
					= new File(upLoadPath, saveFileName);
				try {
					m_file.transferTo(upLoadFile);
				} catch (Exception e) {
					e.printStackTrace();
				} //tr
			} // if
			return saveFileName;
			
		} // if
		
		return null;
	} // end fileUpLoad
	 
} // end class
