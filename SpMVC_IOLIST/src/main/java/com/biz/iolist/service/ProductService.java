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
	
	private ProductDao pDao() {
		return session.getMapper(ProductDao.class);
	}
	
	public List<ProductVO> selectAll(){
		ProductDao pDao = session.getMapper(ProductDao.class);
		List<ProductVO> proList = pDao.selectAll();
		return proList;
	}
	
	public String getPName(String p_code) {
		ProductVO vo = pDao().findByPCode(p_code);
		return vo.getP_name();
	}
	
	public int insert(ProductVO productVO) {
		// TODO Auto-generated method stub
		
		ProductDao pDao = session.getMapper(ProductDao.class);
		int ret = pDao.insert(productVO);
		return ret;
	}

	public List<ProductVO> findByPName(String p_name) {

		List<ProductVO> proList = pDao().findByPName(p_name);
		return proList;
	}

}
