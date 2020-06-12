package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.OrderDao;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Order;
import com.cisco.prj.entity.Product;

@Service
@Transactional
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	public Order addOrder(Order o) {
		return orderDao.save(o);
	}
}
