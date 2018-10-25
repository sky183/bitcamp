package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bit.model.MemberInfo;
import com.bit.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
@SessionAttributes("memberInfo") // "memberInfo" //id라는 키로 저장된 attribute는 세션객체에 저장 됨
public class MemberRegController {

	@Autowired
	MemberRegService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMemberRegForm() {
		ModelAndView modelAndView = new ModelAndView();

		// WEB-INF/views/***.jsp
		modelAndView.setViewName("member/memberRegForm");

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView memberReg(MemberInfo member, HttpServletRequest request, SessionStatus session) throws Exception {

		System.out.println(member);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("member/myPage");

		try {
			service.memberReg(member, request);
			modelAndView.addObject("memberInfo", member);
		} catch (Exception e) {
			modelAndView.addObject("error", "이미 등록된 아이디 입니다.");
			session.setComplete();
			modelAndView.setViewName("member/memberRegForm");
		} 
		return modelAndView;
	}

}