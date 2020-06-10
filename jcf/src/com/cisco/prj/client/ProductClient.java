package com.cisco.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.cisco.prj.entity.Product;

public class ProductClient {

	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<>();
		
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		
		
		Collections.sort(products);
		
		for(Product p : products) {
			System.out.println(p);
		}
		
		System.out.println("************");
		
		System.out.println("Sort based on Price:");
		
		Collections.sort(products, (p1, p2) -> (int)(p1.getPrice() - p2.getPrice()));
		for(Product p : products) {
			System.out.println(p);
		}
		
		System.out.println("Sort based on Name:");
	 
		Collections.sort(products, (p1, p2) -> 
			(p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase())));
//		Collections.sort(products, (p1, p2) -> (p1.getName().length() -  p2.getName().length()));
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
