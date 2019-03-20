package com.biz.file.controller;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.file.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

@MultipartConfig(maxFileSize=10000000)
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	FileUpService fService;
	
	@RequestMapping(value="/file_up",method=RequestMethod.GET)
	public String file() {
		return "body/file_up_form";
	}
	
	@ResponseBody
	@RequestMapping(value="/file",method=RequestMethod.POST)
	public String file(@RequestParam MultipartFile file) {
		
		fService.upload(file);
		return "OK";
	}
	
}
