package com.biz.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.BookDao;
import com.biz.rent.model.BookVO;

@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookDao bDao;
	
	@Override
	public List<BookVO> selectAll() {
		List<BookVO> bookList = bDao.selectAll();
		return bookList;
	}

	@Override
	public BookVO findById(long book_seq) {
		BookVO vo = bDao.findById(book_seq);
		return vo;
	}

	@Override
	public int insert(BookVO bookVO) {
		int ret = bDao.insert(bookVO);
		return ret;
	}

	@Override
	public int update(BookVO bookVO) {

		int ret = bDao.update(bookVO);
		return ret;
	}

	@Override
	public int delete(long book_seq) {
		int ret = bDao.delete(book_seq);
		return ret ;
	}

}
