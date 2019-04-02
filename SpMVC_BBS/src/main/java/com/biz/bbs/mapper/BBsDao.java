package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.bbs.model.BBsVO;

public interface BBsDao {
	
	public List<BBsVO> selectAll() ;
	
	public List<BBsVO> pageSelect(@Param("sRow") long sRow, 
									@Param("eRow") long eRow);

}
