package com.sb.board;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sb.board.model.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle( // 컨트롤러 실행전 :등록된 순서대로 preHandle() 실행
			HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// 쿠키값 가져오기
		Cookie[] cookies = request.getCookies();

		MemberVO member = new MemberVO();

		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];

				if (c.getName().equals("member")) {
					
					member.setName(c.getValue());
					
					HttpSession session = request.getSession();
					
					session.setAttribute("member", member);
					
					return true;
				}

			}

		}

		// 세션에 로그인 정보 유부 확인
		HttpSession session = request.getSession(false);

		if (session != null) {

			member = (MemberVO) session.getAttribute("member");

			if (member != null)
				return true;

		}

		response.sendRedirect(request.getContextPath() + "/login");

		return false;
	}

}
