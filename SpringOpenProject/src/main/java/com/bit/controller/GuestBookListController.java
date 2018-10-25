package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.exception.ServiceException;
import com.bit.model.MessageListView;
import com.bit.service.GetMessageListService;

@Controller
public class GuestBookListController {
	
	@Autowired
	private GetMessageListService service;
	
	@RequestMapping("/list")
	public ModelAndView getList(@RequestParam(value="page", defaultValue="1") int pageNumber) throws ServiceException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("guestbook/list");
		
		MessageListView listView = service.getMessageList(pageNumber);
		
		modelAndView.addObject("viewData", listView);
		
		return modelAndView;
	}
	
	
}
