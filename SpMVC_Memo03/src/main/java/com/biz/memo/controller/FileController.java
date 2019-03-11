package com.biz.memo.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.memo.model.MemoVO;
import com.biz.memo.service.FileService;
import com.biz.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {

	// tomcat서버에 대한 정보를 담고 있는 클래스
	@Autowired
	ServletContext context;
	
	@Autowired
	FileService fService;
	
	@Autowired	
	MemoService mService;
	
	@ResponseBody
	@RequestMapping(value="memo_file",method=RequestMethod.POST)
	public String fileUp(@ModelAttribute MemoVO memoVO,
			@RequestParam MultipartFile m_file){

		
		mService.save(memoVO);
		
		// 파일정보를 tbl_files에 저장하기
		
		String saveFileName = fService.fileUpload(memoVO, m_file);
		return "<img src='" 
				+ context.getContextPath() // project context Path 
				+ "/files/" 				// file 저장된 path
				+ saveFileName + "' />" ;	// 실제 파일 이름
		// return "bodys/memo_list";
	}
}
