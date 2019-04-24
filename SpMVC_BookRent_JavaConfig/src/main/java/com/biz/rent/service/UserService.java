package com.biz.rent.service;

import java.util.List;

import com.biz.rent.model.UserVO;

public interface UserService {

	public List<UserVO> getSearchList(String s_string) ;
	
}
