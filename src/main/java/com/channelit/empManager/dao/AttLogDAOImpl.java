package com.channelit.empManager.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.channelit.empManager.model.AttLog;

@Repository ("attLogDao")
public class AttLogDAOImpl extends AbstractDAO<Integer, AttLog> 
implements AttLogDAO 
{

	@SuppressWarnings("unchecked")
	@Override
	public List<AttLog> getLogsByEmpId(int empId) {
		// TODO Auto-generated method stub
		String empLogStr = "from AttLog empLog where empLog.employee = :empid";
		List<AttLog> attLogList =  getSession().createQuery(empLogStr)
				.setInteger("empid", empId).list();
		return attLogList;
	}

	
}
