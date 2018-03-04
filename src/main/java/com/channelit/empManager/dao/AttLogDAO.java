package com.channelit.empManager.dao;

import java.util.List;

import com.channelit.empManager.model.AttLog;

public interface AttLogDAO {

	List<AttLog> getLogsByEmpId(int empId);
}
