package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.memo.model.MemoVO;

@Controller
public class FileController {

	@ResponseBody
	@RequestMapping(value="memo_file",method=RequestMethod.POST)
	public String fileUp(@ModelAttribute MemoVO memoVO,
			@RequestParam("m_file") MultipartFile file){
				
		String fileName = file.getOriginalFilename();
		return fileName;
		
		// return "bodys/memo_list";
	}
	
}
