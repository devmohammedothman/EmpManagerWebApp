package com.channelit.empManager.service;

import java.util.List;

import com.channelit.empManager.model.AttLog;

public interface AttLogService {

	
	List<AttLog> getLogsByEmpId(int empId);
}
