package com.biz.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.RentDao;
import com.biz.rent.model.CartVO;

@Service
public class RentService {

	
	@Autowired
	RentDao rDao;
	

	public int cart_insert(List<CartVO> cartList) {
		
		int ret = 0;
		for(CartVO vo : cartList) {
			ret += rDao.check_out_insert(vo);
		}
		return ret;
		
	}
	
	
}
