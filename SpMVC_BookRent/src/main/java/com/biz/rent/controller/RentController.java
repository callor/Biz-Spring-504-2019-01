package com.biz.rent.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.rent.model.CartVO;
import com.biz.rent.service.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RentController {
	
	@Autowired
	RentService rService;
	
	@ResponseBody
	@RequestMapping(value="check_out",
			method=RequestMethod.GET,
			produces = "text/html;charset=utf8")
	public String check_out(HttpSession httpSession) {
		
		List<CartVO> cartList = (List)httpSession.getAttribute("CART");
		if(cartList == null) {
			return "장바구니 비어있습니다";
		}
		for(CartVO vo : cartList) {
			log.debug("CartList : " + vo.toString());
		}
		int ret = rService.cart_insert(cartList);
		
		httpSession.removeAttribute("CART"); // 삭제하기
		httpSession.setAttribute("CART", null); // 값만 삭제하기
		return "CHECK_OK";
		
	}
}
