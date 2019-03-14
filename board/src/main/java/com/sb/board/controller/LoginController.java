package com.sb.board.controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sb.board.model.MemberVO;
import com.sb.board.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginForm() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("login");

		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "pw", required = false) String pw,
			@RequestParam(value = "rememberSession", required = false) String rememberSession, HttpSession session,
			HttpServletResponse response) throws SQLException {

		ModelAndView modelAndView = new ModelAndView();

		// userId 또는 userPw가 null 이 아닌 경우
		if (id != null && pw != null) {

			if (loginService.login(id, pw, session)) {

				modelAndView.setViewName("redirect:/");
				
				MemberVO member = (MemberVO) session.getAttribute("member");
				
				if ("on".equals(rememberSession)) {
					Cookie cookie = new Cookie("member", member.getName());
					cookie.setMaxAge(60*60*24);
					response.addCookie(cookie);
				} else {
					Cookie cookie = new Cookie("member", "");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}

			} else {

				modelAndView.setViewName("login"); // 경로
				modelAndView.addObject("error", "아이디 또는 비밀번호가 틀렸습니다.");
				Cookie cookie = new Cookie("member", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);

				// 세션의 종료
				session.invalidate();
			}
		}

		return modelAndView;
	}

	@RequestMapping("/logout") // 요청한 주소로 들어온다
	public String logout(HttpSession session) {

		// 세션의 종료
		session.invalidate();

		return "redirect:/login";

	}
}
