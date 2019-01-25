package com.biz.memo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/yes")
	public String yes() {
		return "yes" ;
	}

}
