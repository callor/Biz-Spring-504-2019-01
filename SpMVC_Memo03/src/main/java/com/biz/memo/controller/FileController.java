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
	@RequestMapping(value="memo_file",
					method=RequestMethod.POST,
					produces="text/html;charset=utf8")
	public String fileUp(@ModelAttribute MemoVO memoVO,
			@RequestParam("m_file") MultipartFile file){

		// memoVO담겨있는 메모내용을 tbl_memo table에 저장하는
		// mService.save(memoVO);
		
		// /files 디렉토리(폴더)에 파일을 저장하고
		// 파일정보를 tbl_files에 저장하기
		String saveFileName = fService.fileUpload(memoVO, file);
		return "<img src='" 
				+ context.getContextPath() // project context Path 
				+ "/files/" 				// file 저장된 path
				+ saveFileName + "' />" ;	// 실제 파일 이름
		// return "bodys/memo_list";
	}
}
