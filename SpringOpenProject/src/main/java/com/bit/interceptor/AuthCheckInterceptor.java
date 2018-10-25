package com.bit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if (session != null) {
			Object obj = session.getAttribute("memberInfo");
			
			if (obj != null) {
				return true;
			}
		}
		
		//세션에 로그인 정보 유무 확인  -> return tru : 정상적인 controller 실행
		response.sendRedirect(request.getContextPath()+ "/loginFail");
		
		return false;
	}
	
}
