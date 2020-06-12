package com.cisco.prj.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoMySQLImpl implements EmployeeDao {

	@Override
	public void printEmployee() {
		System.out.println("Employee stored in MySQL!!!");
	}

}
