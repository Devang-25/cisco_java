package com.cisco.prj.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoMongoImpl implements EmployeeDao {

	@Override
	public void printEmployee() {
		System.out.println("Employee stored in MongoDBBBBBB!!!");
	}

}
