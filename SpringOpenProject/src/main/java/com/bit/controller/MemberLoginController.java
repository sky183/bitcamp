package com.bit.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bit.model.MemberInfo;
import com.bit.service.MemberLoginService;


@Controller
@SessionAttributes("memberInfo")
public class MemberLoginController {
	
	@Autowired
	MemberLoginService service;
	
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public ModelAndView getLogOut(SessionStatus session) {
		session.setComplete();
		return new ModelAndView("redirect:/member/login");
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public ModelAndView getLoginForm(@RequestParam(value="no", required=false, defaultValue="1") int no) {
		return new ModelAndView("member/loginForm");
	}
	
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public ModelAndView loginProcess(
			@RequestParam(value="userId", required=false) String userId,
			@RequestParam(value="password", required=false) String password, 
			@RequestParam(value="chk", required=false) String chk,
			HttpServletRequest request, SessionStatus session, HttpServletResponse response ) {
		
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		MemberInfo member = new MemberInfo();
		
		if(userId == null || password == null) {
			modelAndView.addObject("error", "아이디 또는 패스워드를 입력해주세요.");
			modelAndView.setViewName("member/loginForm");
			return modelAndView;
		}
		
		modelAndView.setViewName("member/myPage");
		
		try {
			member = service.memberLogin(userId, password);
			modelAndView.addObject("memberInfo", member);
		} catch (Exception e) {
			modelAndView.addObject("error", "아이디 또는 패스워드가 틀렸습니다.");
			modelAndView.setViewName("member/loginForm");
/*			HttpSession session = request.getSession();*/
			session.setComplete();
		} /*catch (IllegalStateException e) {
			modelAndView.setViewName("member/memberFail");
		} catch (IOException e) {
			modelAndView.setViewName("member/memberFail");
		}*/
		
		if (chk != null && !(chk.equals(""))) {
			Cookie cookie = new Cookie("checked", member.getUserId());
			cookie.setMaxAge(24*60*60*7);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("checked", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

			
		return modelAndView;
	}
	
	
}
