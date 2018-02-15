package com.channelit.empManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channelit.empManager.dao.EmployeeDAO;
import com.channelit.empManager.model.Employee;

@Service ("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void deleteEmployeeBySsn(String email) {
		// TODO Auto-generated method stub
		
		employeeDao.deleteEmployeeByEmail(email);
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		
		return employeeDao.findAllEmployees();
		
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmployeeEmailUnique(Integer id, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee loginEmployee(String username, String password) {
		// TODO Auto-generated method stub
		
		return employeeDao.loginEmployee(username, password);
	}

}
