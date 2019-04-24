package com.biz.rent.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rent.model.BookVO;
import com.biz.rent.model.RentVO;
import com.biz.rent.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes({"bookVO","rentVO","userVO"})
public class HomeController {
	
	@ModelAttribute("bookVO")
	public BookVO newBook() {
		return new BookVO();
	}

	@ModelAttribute("rentVO")
	public RentVO newRent() {
		RentVO rentVO = new RentVO();
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String today = sd.format(date);
		
		// 오늘로 부터 7일 후의 날짜 값을 생성하기 위한 코드
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);
		// cal.add(Calendar.DAY_OF_MONTH, 1);
		
		String today_7 = sd.format(cal.getTime()); 
		
		rentVO.setRent_date(today);
		rentVO.setRent_return_date(today_7);
		
		return rentVO;
	}

	// java 8
	public void dateTime() {
		
		LocalDate ld = LocalDate.now(); // 현재 날짜
		LocalDate ld_p7 = ld.plusDays(7); // 7일 후의 날짜
		
		LocalDate ld_m7 = ld.minusDays(7); // 일 이전의 날짜
		LocalDate _ld = ld.minusMonths(1); // 1개월 이전의 날짜
		
	}
	
	
	@ModelAttribute("userVO")
	public UserVO newUser() {
		return new UserVO();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(
			@ModelAttribute("rentVO") RentVO rentVO, 
			Model model) {
		
		log.debug(rentVO.toString());
		
		model.addAttribute("rentVO",rentVO);
		return "home";
	}
	
}
