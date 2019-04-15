package com.biz.iolist.mapper;

import java.util.List;

import com.biz.iolist.model.ProductVO;

public interface ProductDao {

	public List<ProductVO> selectAll();
	public ProductVO findByPCode(String p_code);
	
	public int insert(ProductVO productVO);
	public int update(ProductVO productVO);
	public int delete(String d_code);
	public List<ProductVO> findByPName(String p_name);
	
}
