package com.channelit.empManager.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.channelit.empManager.model.Employee;
import com.channelit.empManager.service.EmployeeService;
import com.channelit.empManager.utils.PathConstants;

@Controller
public class EmployeeController {

private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService service;
	
	
	@RequestMapping (value = {"/registeration"} , method = RequestMethod.GET)
	public String goRegisteration(ModelMap model)
	{
				
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		
		return PathConstants.CONST_REGISTER_VIEW;
	}
	
	@RequestMapping (value = {"/registeration"} , method = RequestMethod.POST)
	public String doRegisteration(
			@Valid 
			@ModelAttribute ("employee")
			Employee employee, 
			BindingResult result,
			RedirectAttributes model)
	{
		logger.info("New Employee Handler called");
		
		try
		{
			if(result.hasErrors())
			{
				return PathConstants.CONST_REGISTER_VIEW;
			}
			service.saveEmployee(employee);
			
			model.addFlashAttribute("employee", employee);
			
		}
		catch(Exception ex)
		{
			logger.error(ex.getMessage());
			result.addError(new ObjectError("AddEmployeeErrorMsg", ex.getMessage()));
		}
		return "redirect:/"+PathConstants.CONST_INDEX;
	}
	
	@RequestMapping (value = {"/attendancelogs"} , method = RequestMethod.GET)
	public String goAttendance()
	{
		return PathConstants.CONST_ATTENDANCEVIEW;
	}
	@RequestMapping (value = {"/check"} , method = RequestMethod.GET)
	public String gonewFile()
	{
		return "NewFile";
	}
}
