package com.biz.file.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String file(Model model) {
		
		model.addAttribute("BODY","FILE_UP");
		return "home";
	}

	@RequestMapping(value="/files_up",method=RequestMethod.GET)
	public String files(Model model) {
		
		model.addAttribute("BODY","FILES_UP");
		return "home";
	}

	
	
	@ResponseBody
	@RequestMapping(value="/file",method=RequestMethod.POST)
	public String file(@RequestParam MultipartFile file) {
		
		fService.upload(file);
		return "OK";
	}

	@ResponseBody
	@RequestMapping(value="/files",method=RequestMethod.POST)
	public String files(MultipartHttpServletRequest files) {
		
		List<String> fileName = fService.uploads(files);
		return "OK";
	}


	
	
}
