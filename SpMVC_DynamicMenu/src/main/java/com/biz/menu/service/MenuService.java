package com.biz.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.menu.model.DropMenuDto;
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
	
	public List<DropMenuDto> getDropMenu(){
		List<DropMenuDto> dropMenuList = new ArrayList<DropMenuDto>();
		
		DropMenuDto menuDto = new DropMenuDto();
		
		menuDto.setMenu_id("M0001");
		menuDto.setMenu_title("홈");
		menuDto.setMenu_href("/");
		dropMenuList.add(menuDto);

		menuDto = new DropMenuDto();
		menuDto.setMenu_id("M0002");
		menuDto.setMenu_title("게시판");
		menuDto.setMenu_href("#");
		dropMenuList.add(menuDto);

		
		List<DropMenuDto> subMenus = new ArrayList<DropMenuDto>();

		menuDto = new DropMenuDto();
		menuDto.setMenu_id("M0004");
		menuDto.setMenu_title("회원리스트");
		menuDto.setMenu_href("#");
		subMenus.add(menuDto);

		menuDto = new DropMenuDto();
		menuDto.setMenu_id("M0005");
		menuDto.setMenu_title("시스템정보");
		menuDto.setMenu_href("#");
		subMenus.add(menuDto);
				
		menuDto = new DropMenuDto();
		menuDto.setMenu_id("M0003");
		menuDto.setMenu_title("관리자");
		menuDto.setMenu_href(null);
		menuDto.setSub_menus(subMenus);
		dropMenuList.add(menuDto);
		
		return dropMenuList;
	}
	
}


