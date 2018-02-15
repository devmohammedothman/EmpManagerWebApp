package com.channelit.empManager.service;

import java.util.List;

import com.channelit.empManager.model.Employee;

public interface EmployeeService {
	
	Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeBySsn(String email);
	
	List findAllEmployees();
	
	Employee findEmployeeByEmail(String email);
	
	Employee loginEmployee(String username,String password);
	
	boolean isEmployeeEmailUnique(Integer id, String email);

}
