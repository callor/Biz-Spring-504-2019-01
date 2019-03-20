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
	public List<String> files(MultipartHttpServletRequest files) {
		
		List<String> fileNames = fService.uploads(files);
		for(String file : fileNames) {
			log.debug("파일들 : " + file);
		}
		return fileNames;
	}
	
	/*
	 * @Controller 에서
	 * 
	 * @ResponseBody 가 설정된 method가 
	 * String(문자열)을 return 하면
	 * 문자열 자체가 client에게 전송되어
	 * web browser에게 문자열이 찍히게 된다.
	 * 
	 * @ResponseBody가 설정이 안된 method가
	 * String(문자열)을 return 하면
	 * WEB-INF/views/문자열.jsp 파일을 찾아 읽어서 렌더링 한후
	 * client에게 전송한다.
	 * 
	 * 또한 
	 * @RestController로 설정하게 되면
	 * 모든 method가 자동으로 @ResponseBody로 설정이 되어 버린다.
	 * 
	 * 
	 * 그리고,
	 * jackson-bind를 Depenency에 추가해 주게 되면
	 * @ReponseBody는 String 뿐만아니라
	 * List나 사용자가 직접 생성한 클래스 type을 return 할수 있고
	 * 해당 내용은 적절하게 변환되어 json 형태로
	 * client에게 전송된다.
	 */
	
}
