package com.biz.rent.mapper;

import org.apache.ibatis.annotations.InsertProvider;

import com.biz.rent.model.CartVO;

public interface RentDao {
	
	@InsertProvider(type=RentSQL.class,method="rent_insert_sql")
	public int check_out_insert(CartVO cartVO);
	
}
