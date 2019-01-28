package com.biz.addr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.addr.vo.AddrVO;

@Controller
public class AddrController {
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String addr_insert() {
		return "addr_insert" ;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String addr_insert(@ModelAttribute AddrVO vo, Model model) {
		
		model.addAttribute("ADDR",vo);
		// System.out.println(vo);
		return "yes" ;
	}

	
	
}
