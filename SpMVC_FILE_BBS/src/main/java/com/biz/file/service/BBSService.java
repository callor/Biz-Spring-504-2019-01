package com.biz.file.service;

import java.util.List;

import com.biz.file.model.BoardVO;

public interface BBSService {

	public List<BoardVO> selectAll();
	public BoardVO findById(long id);
	public List<BoardVO> findByUserId(String b_userid);
	
	public BoardVO UpdateHit(long id, String b_userid);
	
	public int insert(BoardVO boardVO);
	public int update(BoardVO boardVO);
	public int delete(long id);
	
}
