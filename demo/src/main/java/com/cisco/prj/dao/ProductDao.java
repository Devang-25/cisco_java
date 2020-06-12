package com.cisco.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cisco.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
