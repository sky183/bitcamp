package com.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.model.MemberInfo;

import com.bit.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService service;

	@RequestMapping("/memberList")
	public String memListView() {
		return "member/memberList";
	}

	@RequestMapping("/memberList/viewType")
	public ModelAndView getMemberList(@RequestParam(value = "type", defaultValue = "HTML") String type)
			throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		
		switch (type) {
		case "HTML":
			modelAndView.setViewName("/member/viewTypeHTML");
			break;
		case "JSON":
			modelAndView.setViewName("/member/viewTypeJSON");
			break;
		case "XML":
			modelAndView.setViewName("/member/viewTypeXML");
			break;
		}
		
		List<MemberInfo> members = service.getMemberList();

		modelAndView.addObject("members", members);



		return modelAndView;
	}

}
