package com.biz.rent.service;

import java.util.List;

import com.biz.rent.model.BookVO;

public interface BookService {

	public List<BookVO> selectAll();
	public BookVO findById(long book_seq);
	public int insert(BookVO bookVO);
	public int update(BookVO bookVO);
	public int delete(long book_seq);
	
}
