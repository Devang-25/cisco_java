package com.cisco.prj.client;

import com.cisco.prj.dao.DaoException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoMySQLImpl;
import com.cisco.prj.entity.Product;

public class InsertClient {

	public static void main(String[] args) {
		ProductDao dao = new ProductDaoMySQLImpl();
		try {
			Product p = new Product(0, "LG AC", 45000.00, "AC");
			dao.addProduct(p);
			System.out.println("Product added successfully!!");
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
