package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.ProductVO;

@Service
public class ProductService {

	@Autowired
	SqlSession session;
	
	public List<ProductVO> selectAll(){
		ProductDao pDao = session.getMapper(ProductDao.class);
		List<ProductVO> proList = pDao.selectAll();
		return proList;
	}
	
	public int insert(ProductVO productVO) {
		// TODO Auto-generated method stub
		
		ProductDao pDao = session.getMapper(ProductDao.class);
		int ret = pDao.insert(productVO);
		return ret;
	}

}
