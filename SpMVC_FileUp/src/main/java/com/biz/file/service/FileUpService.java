package com.biz.file.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileUpService {

	// 파일을 업로드 하기 위해 서버의 실제 디렉토리 경로를 추출 하는데
	// 사용할 ServletContext를 선언
	@Autowired
	ServletContext context;
	
	public String upload(MultipartFile file) {

		// 서버의 실제 디렉토리 경로를 추출
		String realPath = context.getRealPath("/files/");
		
		// 서버의 실제 디렉토리 경로를 추출하고
		// 파일을 저장할 폴더(/files/)가 만들어 졌는지 확인하고
		// 없으면 생성을 해 주어 한다.
		
		// 운영체제한테 /files/ 정보를 달라라고 요청
		File dir = new File(realPath); 	
		if(!dir.exists()) // 만약 /files/ 에 대한 정보가 없으면
						  // 디렉토리가 없으면
			dir.mkdir();  // 생성하라
			// dir.mkdirs() ; // 다중경로 디렉토리 생성
		
		// 업로드한 파일에 여러가지 문제가 발생하면
		// 더이상 진행하지 말라
		if(file.isEmpty() || file == null) return null;
		
		// 업로드할 파일의 이름을 추출
		String realFile = file.getOriginalFilename();
		
		// 32자리의 16진수 문자열로 된 임의 값을 생성한다. 
		String saveFile = UUID.randomUUID().toString();
		saveFile += realFile;
		
		// 원래의 파일이름으로 파일을 업로드 할경우
		// 같은 이름이 있을 경우 앞에 업로드된 파일이 나중 파일로
		// 교체 되어 버리는 현상이 있어서
		// 실제로 파일을 업로드 할때는 임의의 이름으로 변경 해주는 것이
		// 좋다.
		
		// 업로드한 파일을 서버 디렉토리에 저장하기 위해서
		// 파일 객체를 생성
		// File upFile = new File(realPath,realFile);
		File upFile = new File(realPath, saveFile);
		
		try {
			file.transferTo(upFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFile ;
	
	}

	public List<String> uploads(MultipartHttpServletRequest files) {
		// TODO Auto-generated method stub
		List<MultipartFile> fileList = files.getFiles("files");
		List<String> fileNames = new ArrayList<String>();
		
		// fileNames에는 이름을 변경하여 서버에 업로드한
		// 파일들의 이름리스트가 만들어진다.
		for(MultipartFile file : fileList) {
			fileNames.add(this.upload(file));
		}
		return fileNames;

	}

}
