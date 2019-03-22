package com.biz.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.file.mapper.BoardDao;
import com.biz.file.model.BoardVO;

@Service
public class BoardServiceImp implements BoardService {

	
	@Autowired
	BoardDao bDao;
	
	@Override
	public List<BoardVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> findByUserId(String b_userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
