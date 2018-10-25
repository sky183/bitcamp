package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.model.MemberInfo;
import com.bit.service.MemberDeleteService;

@Controller
public class MemberDeleteController {

	@Autowired
	private MemberDeleteService service;

	@RequestMapping("/memberDelete/{userId:.+}/{userPhoto:.+}") // ${userId}
	public String memberDelete(@PathVariable("userId") String userId, @PathVariable("userPhoto") String userPhoto,
			HttpServletRequest request, HttpSession session) throws Exception {

		MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");
		
		if (memberInfo.getUserId().equals(userId)) {
			return "errorPage/CanNotDelete";
		}

		try {
			service.memberDelete(userId, userPhoto, request);

		} catch (Exception e) {

		}

		return "redirect:/memberList";
	}

	@RequestMapping("/memberDelete/{userId:.+}/")
	public String memberDeleteId(@PathVariable("userId") String userId, HttpServletRequest request) throws Exception {

		try {
			service.memberDelete(userId, null, request);

		} catch (Exception e) {

		}

		return "redirect:/memberList";
	}
}
