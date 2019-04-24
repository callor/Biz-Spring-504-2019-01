package com.biz.rent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rent.model.BookVO;

public interface BookDao {

	/*
	 * 기본 CRUD 구성하는 mehtod
	 */
	@Select("SELECT * FROM tbl_book")
	public List<BookVO> selectAll();

	@Select("SELECT * FROM tbl_book WHERE book_seq = #{book_seq}")
	public BookVO findById(long book_seq);
	
	@InsertProvider(type=BookSQL.class,method="book_insert_sql")
	public int insert(BookVO bookVO);
	
	@UpdateProvider(type=BookSQL.class,method="book_update_sql")
	public int update(BookVO bookVO);
	
	@Delete("DELETE FROM tbl_book WHERE book_seq = #{book_seq}")
	public int delete(long book_seq);
	
	/*
	 * 도서정보 검색
	 */
	@Select("SELECT * FROM tbl_book WHERE book_title like '%' || #{s_string} || '%'  ")
	public List<BookVO> getSearchList(String s_string) ;

	@Select("SELECT * FROM tbl_book WHERE book_isbn = #{s_string}")
	public List<BookVO> getSearchListByIsbn(String s_string);
	
	
}
