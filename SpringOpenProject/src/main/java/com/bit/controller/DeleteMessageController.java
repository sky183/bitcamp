package com.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.exception.InvalidMessagePassowrdException;
import com.bit.exception.MemberNotFoundException;
import com.bit.exception.MessageNotFoundException;
import com.bit.exception.ServiceException;
import com.bit.model.MemberInfo;
import com.bit.service.DeleteMessageService;

@Controller
public class DeleteMessageController {

	@Autowired
	DeleteMessageService deleteService;

/*	@RequestMapping(value = "/deleteMessage", method = RequestMethod.GET)
	public ModelAndView confirmDeletion(@RequestParam(value = "messageId", required = true) int messageId) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("guestbook/confirmDeletion");

		modelAndView.addObject("messageId", messageId);

		return modelAndView;
	}*/

	@RequestMapping(value = "/deleteMessage", method = RequestMethod.GET)
	public ModelAndView deleteMessage(@RequestParam(value = "messageId", required = true) int messageId,
			HttpSession session) //@RequestParam(value = "password", required = true) String password
			throws ServiceException, MessageNotFoundException, MemberNotFoundException {

		MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");

		ModelAndView modelAndView = new ModelAndView();

		String viewName = "guestbook/deleteMessage";

		/* boolean invalidPassowrd = false; */
		int status = 0;

		try {
			if (memberInfo != null) {
				deleteService.deleteMessage(messageId, memberInfo.getUserId(), "1");
			} else {
				status = 4;
			}
			
		} catch (ServiceException ex) {
//			invalidPassowrd = true;
			status = 1;
		} catch (InvalidMessagePassowrdException ex) {
			status = 2;
		} catch (MessageNotFoundException ex) {
			status = 3;
		} catch (MemberNotFoundException ex) {
			status = 4;
		}

		modelAndView.setViewName(viewName);

		modelAndView.addObject("status", status);

		return modelAndView;
	}

}
