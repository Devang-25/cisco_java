package com.cisco.prj.client;

import java.util.List;

import com.cisco.prj.dao.DaoException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoMySQLImpl;
import com.cisco.prj.entity.Product;

public class FetchClient {

	public static void main(String[] args) {
		ProductDao dao = new ProductDaoMySQLImpl();
		
		try {
			List<Product> products = dao.getProducts();
			for(Product p : products) {
				System.out.println(p);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
