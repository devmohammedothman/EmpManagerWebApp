//package com.channelit.empManager.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.channelit.empManager.model.Employee;
//import com.channelit.empManager.model.EmployeeUserDetail;
//
//@Service
//public class EmployeeDetailServiceImpl implements UserDetailsService 
//{
//
//	@Autowired
//	EmployeeService loginService;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		Employee empUser = loginService.loginEmployeeByUserName(username);
//		if(empUser == null)
//			throw new UsernameNotFoundException(username);
//		
//		return new EmployeeUserDetail(empUser);
//	}
//
//}
