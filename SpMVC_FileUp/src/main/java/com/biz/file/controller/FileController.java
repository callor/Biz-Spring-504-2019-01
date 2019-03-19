package com.biz.file.controller;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MultipartConfig(maxFileSize=10000000)
public class FileController {
	
	@RequestMapping(value="file_up_01",method=RequestMethod.GET)
	public String file() {
		return "body/FileUpForm";
	}
	
	@ResponseBody
	@RequestMapping(value="file",method=RequestMethod.POST)
	public String file(@RequestParam MultipartFile file) {
		return "OK";
	}
	
}
