package com.biz.file.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.file.model.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// return super.preHandle(request, response, handler);
		// TODO Auto-generated method stub
		// super.postHandle(request, response, handler, modelAndView);

		// login 정보를 추출하기 위해서
		HttpSession session = request.getSession();

		MemberVO memberVO = (MemberVO) session.getAttribute("login_info");

		// login 정보가 없으면
		if (memberVO == null) {
			session.removeAttribute("login_info");
			response.sendRedirect("/file/login/login?LOGIN_MSG=LOGIN_REQ");
			return false;
		}
		
		return true;

	}

}
