package com.biz.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.rent.model.BookVO;
import com.biz.rent.service.BookService;

@Controller

//class 수준의 mapping
// type(=class) 수준의 mapping
@RequestMapping("/book") 
public class BookController {

	@Autowired
	BookService bService;
	
	/*
	 * 클라이언트에서 도서명을 전달받아서
	 * 도서명에 해당하는 목록을 보여주는 method
	 */
	// method 수준의 mapping
	@RequestMapping(value="/s_list/{string}",method=RequestMethod.GET)
	public String search_list(
			@PathVariable("string") String s_string,
			Model model) {
		
		List<BookVO> bookList = bService.getSearchList(s_string); 
		
		model.addAttribute("BOOKS", bookList);
		return "rent_body/book/book_s_list";
	}
	
}
