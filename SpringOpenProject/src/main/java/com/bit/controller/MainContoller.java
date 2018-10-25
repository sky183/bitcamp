package com.bit.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContoller {
	
	@RequestMapping("/")
	public String main(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("time", formattedDate );
		return "index";
	}
	
	@RequestMapping("/myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	@RequestMapping("/loginFail")
	public String loginFail() {
		return "errorPage/loginFail";
	}
	
	@RequestMapping("/null")
	public String nullpage() {
		return "errorPage/null";
	}
	
	@RequestMapping("/errorPage/member")
	public String member() {
		return "errorPage/member";
	}
	
	
	
}
