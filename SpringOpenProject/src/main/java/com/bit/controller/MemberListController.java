package com.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.model.MemberInfo;

import com.bit.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService service;

	@RequestMapping("/memberList")
	public ModelAndView getMemberList() throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		
		List<MemberInfo> members = service.getMemberList();

		modelAndView.setViewName("member/memberList");

		modelAndView.addObject("members", members);

		return modelAndView;
	}

}
