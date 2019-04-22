package com.biz.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.UserDao;
import com.biz.rent.model.UserVO;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao uDao;
	
	@Override
	public List<UserVO> getSearchList(String s_string) {
		return uDao.getSearchList(s_string);
	}
}
