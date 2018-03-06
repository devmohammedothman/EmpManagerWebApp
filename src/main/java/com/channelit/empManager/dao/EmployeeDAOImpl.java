package com.channelit.empManager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.channelit.empManager.model.Employee;

@Repository ("employeeDao")
public class EmployeeDAOImpl extends AbstractDAO<Integer, Employee> implements EmployeeDAO {

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		persist(employee);
	}

	@Override
	public void deleteEmployeeByEmail(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		return (List)criteria.list();
	}

	@Override
	public Employee findEmployeeByEmail(String Email) {
		// TODO Auto-generated method stub
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("email", Email));
		
		return (Employee) criteria.uniqueResult();
		
	}

	@Override
	public Employee loginEmployee(String username, String password) {
		// TODO Auto-generated method stub
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.eq("active", true));
		return (Employee) criteria.uniqueResult();
	}
	
	@Override
	public Employee loginEmployeeByUserName(String username) {
		// TODO Auto-generated method stub
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		
		return (Employee) criteria.uniqueResult();
	}

}
