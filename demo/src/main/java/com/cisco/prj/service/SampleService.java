package com.cisco.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.EmployeeDao;

@Service
public class SampleService {
	@Autowired
	@Qualifier("employeeDaoMySQLImpl")
	private EmployeeDao empDao;
	
	public void doTask() {
		empDao.printEmployee();
	}
}

