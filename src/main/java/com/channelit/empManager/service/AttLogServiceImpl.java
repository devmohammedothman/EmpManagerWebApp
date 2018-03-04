package com.channelit.empManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channelit.empManager.dao.AttLogDAO;
import com.channelit.empManager.model.AttLog;

@Service ("attLogService")
@Transactional
public class AttLogServiceImpl implements AttLogService {

	@Autowired
	private AttLogDAO attLogDao;
	
	@Override
	public List<AttLog> getLogsByEmpId(int empId) {
		// TODO Auto-generated method stub
		return attLogDao.getLogsByEmpId(empId);
	}

}
