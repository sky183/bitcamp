package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.exception.ServiceException;
import com.bit.model.Message;
import com.bit.model.MessageListView;
import com.bit.service.WriteMessageService;

@Controller
public class WriteMessageController {
	
	@Autowired
	private WriteMessageService writeService;
	
	@RequestMapping(value="/writeMessage", method=RequestMethod.POST)
	public ModelAndView writeMessage(Message message) throws ServiceException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/list");
		
		try {
			writeService.write(message);
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/null");
		}
		
		
		return modelAndView;
	}
	
		
}
