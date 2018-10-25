package com.bit.controller;

import java.lang.reflect.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bit.model.MemberInfo;
import com.bit.service.MemberInfoService;
import com.bit.service.MemberModifyService;

@Controller
public class MemberModifyController {
	
	@Autowired
	private MemberInfoService service;
	
	@Autowired
	private MemberModifyService modifyService;
	
	private MemberInfo memberInfo;
	
	
	@RequestMapping(value="/memberModify/{userId:.+}", method=RequestMethod.GET)
	public ModelAndView memberModify(@PathVariable("userId") String userId, HttpSession session) throws Exception {
			
		ModelAndView modelAndView = new ModelAndView();
		
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		
		if (!memberInfo.getUserId().equals(userId)) {
			modelAndView.setViewName("errorPage/member");
			return modelAndView;
		}
		
		modelAndView.setViewName("member/memberModifyForm");
		try {
			memberInfo = service.selectMember(userId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		modelAndView.addObject("memberInfo", memberInfo);

		return modelAndView;
	}

	@RequestMapping("/memberModified")
	public ModelAndView modified(MemberInfo memberInfo, HttpServletRequest request, HttpSession session) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();

		
		try {
			modifyService.memberModify(memberInfo, request);
			this.memberInfo = (MemberInfo)session.getAttribute("memberInfo");
			if (this.memberInfo.getUserId().equals(memberInfo.getUserId())) {
				/*modelAndView.addObject("memberInfo", memberInfo);*/
				session.setAttribute("memberInfo", memberInfo);
			}
		} catch (Exception e) {
		}

		
		modelAndView.setViewName("redirect:/memberList");
		
		return modelAndView;
	}

}
