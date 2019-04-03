package com.biz.iolist.mapper;

import java.util.List;

import com.biz.iolist.model.DeptVO;

public interface DeptDao {

	public List<DeptVO> selectAll();
	public DeptVO findByDCode(String d_code);
	public int insert(DeptVO deptVO);
	public int update(DeptVO deptVO);
	public int delete(String d_code);

}
