package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.model.Message;
import com.bit.service.ViewService;

@Controller
public class View {

	@Autowired
	private ViewService service;

	@RequestMapping("/view/{id}")
	public String getView(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("id",id);
			
			Message message;
			
			try {
				message = service.getMessage(id);
				model.addAttribute("message", message);
			} catch (Exception e) {
				
			}
					
			
			return "guestbook/view";
		}

}
