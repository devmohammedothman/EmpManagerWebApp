package com.channelit.empManager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.channelit.empManager.model.Employee;
import com.channelit.empManager.utils.PathConstants;

@Controller

public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping (value = {"/","/login"},method = RequestMethod.GET)
	public String login()
	{
		
		return PathConstants.CONST_LOGIN_VIEW;
	}
	
	
	@RequestMapping (value = "/accessdenied",method = RequestMethod.GET)
	public String viewAccessDenied()
	{
		return PathConstants.CONST_ACCESSDENIED_VIEW;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response,ModelMap model) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/"+PathConstants.CONST_LOGIN_VIEW+"?logout";
	}
	
	@RequestMapping (value = {"/index"},method = RequestMethod.GET)
	public String goIndex(ModelMap model)
	{
		//model.addAttribute("user", getPrincipal());
		return PathConstants.CONST_INDEX;
	}
	
//	private String getPrincipal(){
//		String userName = null;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails) {
//			userName = ((UserDetails)principal).getUsername();
//		} else {
//			userName = principal.toString();
//		}
//		return userName;
//	}
}
