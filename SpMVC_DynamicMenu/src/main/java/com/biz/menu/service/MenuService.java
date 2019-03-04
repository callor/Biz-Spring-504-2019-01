package com.biz.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.menu.model.MenuDto;

@Service
public class MenuService {

	
	public List<MenuDto> getMenus() {
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		
		MenuDto menuDto = new MenuDto();
		
		menuDto.setMenu_id("M0001");
		menuDto.setMenu_title("홈");
		menuDto.setMenu_href("/");
		menuList.add(menuDto);

		menuDto = new MenuDto();
		menuDto.setMenu_id("M0002");
		menuDto.setMenu_title("게시판");
		menuDto.setMenu_href("#");
		menuList.add(menuDto);

		menuDto = new MenuDto();
		menuDto.setMenu_id("M0003");
		menuDto.setMenu_title("메모장");
		menuDto.setMenu_href("#");
		menuList.add(menuDto);

		menuDto = new MenuDto();
		menuDto.setMenu_id("M0004");
		menuDto.setMenu_title("로그인");
		menuDto.setMenu_href("#");
		menuList.add(menuDto);
		
		menuDto = new MenuDto();
		menuDto.setMenu_id("M0005");
		menuDto.setMenu_title("회원가입");
		menuDto.setMenu_href("#");
		menuList.add(menuDto);
		
		return menuList;
		
	}
	
}


