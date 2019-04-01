package com.biz.email.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.mapper.MailDao;
import com.biz.email.model.MailVO;

@Service
public class SaveService {

	// 서버에 저장할 주소를 얻어오기 위해 사용
	@Autowired
	ServletContext context;
	
	@Autowired
	SendMailService sMail;
	
	@Autowired
	MailDao mDao;
	
	public void save(MailVO mailVO, MultipartHttpServletRequest files) {
		
		// files는 입력폼의 file tag의 name 항목과 같게
		List<MultipartFile> fileList = files.getFiles("files");
		
		// 선택한 파일 모두 저장
		// for(MultipartFile f : fileList) {
		//	fileUp(f);
		//}
		
		// 2개만 저장을 하고 싶다.
		try {
			// 실제 저장된 파일 이름을 vo에 담기
			String fileName1 = fileUp(fileList.get(0));
			mailVO.setS_file1(fileName1);
			
			String fileName2 = fileUp(fileList.get(1));
			mailVO.setS_file2(fileName2);

		} catch (Exception e) {
			// 오류나면 무시
		}
		
		
		long id = mailVO.getId();
		if(id > 0) { // 편집상태
			mDao.update(mailVO);
		} else {
			mDao.insert(mailVO);
			sMail.sendMail(mailVO);
		}
	}
	
	public String fileUp(MultipartFile file) {
		
		String realFile = file.getOriginalFilename();
		
		// 서버에 저장할 폴더 위치
		String realPath = context.getRealPath("/files/");
		
		File dir = new File(realPath);
		if(dir.exists() != true) { // !dir.exists()
			dir.mkdir(); // 폴더를 생성하라
		}
		
		if(file.isEmpty()) { // 업로드된 파일이 문제 있으면
			return null;
		}
		
		String saveFile = UUID.randomUUID().toString();
		saveFile += realFile; // 새로운 파일이름을 생성
		
		File upFile = new File(realPath, saveFile);
		
		try {
			file.transferTo(upFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saveFile ; // 실제 저장된 파일 이름을 return
		
	}

}
