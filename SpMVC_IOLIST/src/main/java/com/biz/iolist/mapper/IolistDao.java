package com.biz.iolist.mapper;

import java.util.List;

import com.biz.iolist.model.IolistDto;
import com.biz.iolist.model.IolistVO;

public interface IolistDao {

	public List<IolistVO> selectAll();
	public List<IolistDto> iolistJoin();
	
	public IolistVO findById(long io_id);
	public int insert(IolistVO iolistVO);
	public int update(IolistVO iolistVO);
	public int delete(long io_id);
	
}
