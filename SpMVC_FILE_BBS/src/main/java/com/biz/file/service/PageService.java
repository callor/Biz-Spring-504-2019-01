package com.biz.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.file.mapper.PageDao;
import com.biz.file.model.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PageService {

	@Autowired
	PageDao pDao;
	
	public long getCount() {
		return pDao.getCount();
	}
	
	public List<BoardVO> pagiList(int sRow, int eRow){

		long c = pDao.getCount();
		log.debug("COUNT" + c);
		
		log.debug("sRow" + sRow);
		log.debug("eRow" + eRow);
		
		List<BoardVO> bbsList = pDao.selectPage(sRow, eRow);
		return bbsList;
		
	}
	
}
