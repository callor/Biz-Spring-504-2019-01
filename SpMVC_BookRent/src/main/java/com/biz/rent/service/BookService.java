package com.biz.rent.service;

import java.util.List;

import com.biz.rent.model.BookVO;

public interface BookService {

	/*
	 * CRUD 구현 method
	 */
	public List<BookVO> selectAll();
	public BookVO findById(long book_seq);
	public int insert(BookVO bookVO);
	public int update(BookVO bookVO);
	public int delete(long book_seq);
	
	/*
	 * 검색 method
	 */
	public List<BookVO> getSearchList(String s_string) ;
	
}
