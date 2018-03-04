package com.channelit.empManager.dao;

import java.util.List;

import com.channelit.empManager.model.Employee;

public interface EmployeeDAO {

	
	Employee findById(int id);
	void saveEmployee(Employee employee);
	void deleteEmployeeByEmail(String email);
	List<Employee> findAllEmployees();
	Employee findEmployeeByEmail(String Email);
	Employee loginEmployee(String username,String password);
	
	Employee loginEmployeeByUserName(String username);
}
