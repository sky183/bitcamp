package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.bit.model.ProfileCls;

@Controller
public class Comp {
	private static final Logger logger = LoggerFactory.getLogger(Comp.class);
	
	@Autowired 
	private ConfigurableWebApplicationContext subContext;
	
	@Autowired 
	private Environment env;
	
	@Autowired 
	private ProfileCls profileCls;
	
	
	@RequestMapping("/comp")
	public ModelAndView comp(HttpServletRequest request) {
		
	ModelAndView modelAndView = new ModelAndView("index");
	
	System.out.println(request.getContextPath());	
	System.out.println(request.getContextPath());	
	
	System.out.println(request.getAttribute("javax.servlet.forward.request_uri"));
	System.out.println(request.getAttribute( "javax.servlet.include.request_uri"));
	
	System.out.println(request.getRequestURL());
	
	System.out.println(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort());
	
	System.out.println(request.getRequestURL().toString().replace(request.getRequestURI(),""));

	
	// ConfigurableWebApplicationContext 이용
	String[] profiles = subContext.getEnvironment().getActiveProfiles();
	for(String profile : profiles){
		logger.debug( profile );
		System.out.println(profile);
	}
	// Environment 이용
	profiles = env.getActiveProfiles();
	for(String profile : profiles){
		logger.debug( profile );
		System.out.println(profile);
	}
	
	logger.debug(profileCls.getRootPath());
	System.out.println(profileCls.getRootPath());
	
	
	
	return modelAndView;
	
	}
}
