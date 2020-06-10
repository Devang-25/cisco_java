package com.cisco.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.cisco.prj.entity.Product;

public class ProductClient2 {

	public static void main(String[] args) {
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		 
		System.out.println("filter computers");
		// map, filter, forEach, limit, .. can be be applied only on stream of data
		
		// stream of data can come via N/W, database, or any streaming API
		// stream is a channel along which data flows.
//		Predicate<Product> predicate = p -> p.getCategory().equals("computer");
		Consumer<Product> consumer = p -> System.out.println(p);
		
		products.stream()
			.filter(p -> p.getCategory().equals("computer"))
			.forEach(consumer);
		
		// get names of only mobile products [ iPhone, One Plus ]
		
		List<String> names = products.stream()
				.filter(p -> p.getCategory().equals("mobile"))
				.map(p -> p.getName())
				.collect(Collectors.toList());
		
		names.forEach(name -> System.out.println(name));
		
		System.out.println("Reduce :");
		
		double total = products.stream()
						.map(p -> p.getPrice())
						.reduce(0.0, (v1,v2) -> v1 + v2);
		
		System.out.println("Total :" + total);
		
		System.out.println("**********");
		
		Map<String, List<Product>> prodMap =
					products.stream()
					.collect(Collectors.groupingBy(p->p.getCategory()));
		
		prodMap.forEach((k,v) -> {
			System.out.println("Category : " + k);
			v.forEach(p -> System.out.println(p));
		});
	}

}
