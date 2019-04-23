package com.biz.rent.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rent.model.CartVO;
import com.biz.rent.model.RentVO;
import com.biz.rent.service.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rent")
@SessionAttributes("rentVO")
public class CartController {

	
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
	
	@RequestMapping(value="/cart_clear",method=RequestMethod.GET)
	public String cart_clear(HttpSession httpSession) {
		
		// 모든 세션을 제거
		// 혹시모를 다른 session도 모두 삭제하기 때문에 가급적 사용 자제
		// httpSession.invalidate();
		httpSession.setAttribute("CART",null);
		return "rent_body/rent/rent_cart" ;
	}
	
	
	@RequestMapping(value="/cart_item_delete/{index}",method=RequestMethod.GET)
	public String cart_item_delete(
			@PathVariable("index") int index,
			HttpSession httpSession) {
		if(index > 0) {
			List<CartVO> cartList = (List)httpSession.getAttribute("CART");
			if( cartList != null ) {
				cartList.remove(index);
				httpSession.setAttribute("CART", cartList);
			}
		}
		return "rent_body/rent/rent_cart" ;
	}
}
