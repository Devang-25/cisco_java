package com.cisco.prj.client;

import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[5]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");
		
		displayExpensive(products);
		
		displayDetails(products);
	}

	// is This method following OCP ???
	private static void displayDetails(Product[] products) {
		for(Product p : products) {
			System.out.println("*******");
			System.out.println(p.getName() + "," + p.getPrice());
			if(p instanceof Tv) {
				Tv t = (Tv) p;
				System.out.println(t.getScreenType());
			} 
			if(p.getClass() == Mobile.class) {
				Mobile m = (Mobile) p;
				System.out.println(m.getConnectivity());
			}
		}
	}

	// OCP ==> Open for extension, closed for a change
	private static void displayExpensive(Product[] products) {
		for(Product p : products) {
			if(p.isExpensive()) { // polymorphic, Dynamic binding
				System.out.println(p.getName() + " is expensive !!!");
			} else {
				System.out.println(p.getName() + " is not expensive !!!");
			}
		}
	}

}
