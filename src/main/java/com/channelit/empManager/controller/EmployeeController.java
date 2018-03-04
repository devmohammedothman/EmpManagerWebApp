package com.channelit.empManager.controller;

import java.util.List;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.channelit.empManager.model.AttLog;
import com.channelit.empManager.model.Employee;
import com.channelit.empManager.model.EmployeeUserDetail;
import com.channelit.empManager.service.AttLogService;
import com.channelit.empManager.service.EmployeeService;
import com.channelit.empManager.utils.PathConstants;

@Controller
public class EmployeeController {

private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	AttLogService attLogService;
	
	private static int _totalWorkingHours = 0;
	//private static int _totalOverTimeHours = 0;
	//private static final int totalHoursPerMonth = 160; 
	
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
	public String goAttendance(Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Employee currentUser = ((EmployeeUserDetail)authentication.getPrincipal()).getCurrentUser();
		List<AttLog> attLogList =  attLogService.getLogsByEmpId(currentUser.getEmpid());
		model.addAttribute("attLogList", attLogList);
		
		//fill total hours value
		calcTotalHoursWithOverTime(attLogList);
		model.addAttribute("totalHours",_totalWorkingHours);
//		model.addAttribute("totalOverTimeHours",_totalOverTimeHours);
		
		return PathConstants.CONST_ATTENDANCEVIEW;
	}
	@RequestMapping (value = {"/check"} , method = RequestMethod.GET)
	public String gonewFile()
	{
		return "NewFile";
	}
	
	private void calcTotalHoursWithOverTime(List<AttLog> attLogList)
	{
		for(AttLog item: attLogList)
		{
			_totalWorkingHours += item.getWorkingHours();
		}
//		_totalOverTimeHours = totalHoursPerMonth - _totalWorkingHours ;
	}
}
