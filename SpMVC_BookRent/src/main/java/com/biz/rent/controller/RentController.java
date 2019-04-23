package com.biz.rent.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rent.model.CartVO;
import com.biz.rent.model.RentVO;
import com.biz.rent.service.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rent")
@SessionAttributes("rentVO")
public class RentController {

	
	@Autowired	
	RentService rService;
	
	@ModelAttribute("rentVO")
	public RentVO newRent() {
		return new RentVO();
	}

	// @ResponseBody
	@RequestMapping(value="/cart",method=RequestMethod.POST)
	public String cart(
			@ModelAttribute("rentVO") RentVO rentVO,
			Model model,HttpSession httpSession ) {

		try {
			List<CartVO> cart = (List)httpSession.getAttribute("CART");
			List<CartVO> returnCart = rService.addCart(cart,rentVO);
			if(returnCart != null) {
				httpSession.setAttribute("CART",returnCart );	
				for(CartVO vo : returnCart) {
					log.debug("Cart" + vo.toString());
				}
			}
			return "rent_body/rent/rent_cart" ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("rentVO",rentVO);
		return null;

	}
	
}
