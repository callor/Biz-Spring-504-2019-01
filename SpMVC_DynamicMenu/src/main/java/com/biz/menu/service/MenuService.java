package com.biz.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.menu.mapper.MenuDao;
import com.biz.menu.model.DropMenuDto;
import com.biz.menu.model.MenuDto;
import com.biz.menu.model.MenuDto.MenuDtoBuilder;

@Service
public class MenuService {

	
	@Autowired
	MenuDao mDao;
	
	public List<DropMenuDto> getDBMenu() {
		List<DropMenuDto> menuList = mDao.getMenus();
		return menuList;
	}
	
	
	public List<MenuDto> getBuilder() {
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		
		// 생성자와 setter의 장점으로 모두 보유한 방식
		// 생성자 패턴
		//		다량의 데이터를 setting 해야할 경우
		//		생성자에서 직접 데이터를 주입하면서
		//		dto(vo)를 만들수 있다.
		//		단점 : 데이를 주입할때 항상 
		//			순서에 신경을 써야 한다.
		//			만약 순서를 제대로 지키지 않으면
		//			데이터가 엉뚱하게 사용될 수 있다.
		//	생성자 패턴의 그러한 단점을 보완하기 위햇
		//	setter 패턴을 사용한다.
		//		setter 패턴의 가장 큰 단점
		//		일단 코드 길어지고,
		//		난해한(읽기 힘든)코드가 될수 있다.
		
		// Builder 패턴은 생성자호출을 하면서
		// 변수이름을 직접 보고 데이터를 추가할수 있기때문에
		// 순서가 바뀌거나 하는 경우가 없고.
		// setter 패턴처럼 코드가 번거로워지는 현상이 없다.
		MenuDto m = MenuDto
				.builder() // Builder 패턴 방식으로 시작
				.menu_id("M0001")
				.menu_title("홈으로")
				.menu_href("/").build();
					
		menuList.add(m);
		
		menuList.add(MenuDto.builder()
				.menu_id("M0002")
				.menu_title("치킨나라")
				.menu_href("CH1").build()
				);
		menuList.add(MenuDto.builder()
				.menu_id("M0002")
				.menu_title("치킨나라")
				.menu_href("CH1").build()
		);
		menuList.add(MenuDto.builder()
				.menu_id("M0003")
				.menu_title("치킨나라")
				.menu_href("CH1").build()
		);
				
				
		return menuList;
		
	}
	
	public List<MenuDto> getMenus() {
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		
		
		
		menuList.add(new MenuDto("M0010","Home","#"));
		menuList.add(new MenuDto("M0011","Home1","#"));
		menuList.add(new MenuDto("M0012","Home2","#"));
		menuList.add(new MenuDto("M0013","Home3","#"));

		MenuDto menuDto = new MenuDto();
		menuDto.setMenu_title("홈");
		menuDto.setMenu_id("M0001");
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


