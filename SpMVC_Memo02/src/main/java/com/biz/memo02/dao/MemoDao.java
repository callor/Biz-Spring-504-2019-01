package com.biz.memo02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.memo02.vo.MemoVO;

public interface MemoDao {
	
	@Select(MemoSQL.MEMO_SELECT_ALL)
	public List<MemoVO> selectAll();
	
	@Select(MemoSQL.MEMO_FIND_BY_ID)
	public MemoVO findById(long id);
	
	@Insert(MemoSQL.MEMO_INSERT)
	public int insert(MemoVO vo);
	
	@Update(MemoSQL.MEMO_UPDATE)
	public int update(MemoVO vo);
	
	@Delete(MemoSQL.MEMO_DELETE)
	public int delete(long id);

}
