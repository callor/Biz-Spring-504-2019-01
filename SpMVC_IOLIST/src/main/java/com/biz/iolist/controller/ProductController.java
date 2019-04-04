package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.ProductService;

// form과 controller 사이에서 데이터를 공유하기 위한 방법
@SessionAttributes("productVO")
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pService;
	
	@ModelAttribute("productVO")
	public ProductVO newPro() {
		ProductVO vo = new ProductVO();
		return vo;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<ProductVO> proList = pService.selectAll();
		
		model.addAttribute("LIST", proList);
		model.addAttribute("BODY","P_LIST");
		return "home";
	}

	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(
			@ModelAttribute("productVO") ProductVO productVO,
						Model model) {
		
		model.addAttribute("productVO",productVO);
		model.addAttribute("BODY","P_WRITE");
		return "home";

	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(
			@ModelAttribute("productVO") ProductVO productVO, 
			Model model,SessionStatus session) {
		
		int ret = pService.insert(productVO);
		if(ret > 0) {
			return "redirect:/product/list";
		} else {
			model.addAttribute("BODY", "P_WRITE");
			model.addAttribute("productVO", productVO);
			return "home";
		}
		// model.addAttribute("MSG","데이터 추가 성공!!!");
		// return "home";

	}

	
}
