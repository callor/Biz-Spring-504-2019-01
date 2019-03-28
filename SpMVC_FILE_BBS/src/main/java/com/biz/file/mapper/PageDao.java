package com.biz.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.file.model.BoardVO;

public interface PageDao {
	
	@Select("SELECT COUNT(*) FROM tbl_board ")
	public long getCount();
	
	@Select("SELECT * FROM " + 
			"( SELECT ROWNUM R, B.* FROM tbl_board B " + 
			" WHERE b_date > '0000-00-00' ) M " + 
			" WHERE R BETWEEN #{start} AND #{end} " )
	public List<BoardVO> selectPage(
							@Param("start") int start, 
							@Param("end") int end);
	
}
