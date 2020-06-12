package com.cisco.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cisco.prj.dao.DaoException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoMySQLImpl;
import com.cisco.prj.entity.Product;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDao dao = new ProductDaoMySQLImpl();
		try {
			List<Product> products = dao.getProducts();
			request.setAttribute("products", products);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
		}

//		PrintWriter out = response.getWriter(); 
//		response.setContentType("text/html");
//		out.print("<html><body>");
//			out.print("<table border=\"1\">");
//				out.print("<tr><th>ID</th><th>Name</th><th>Price</th><th>Category</th></tr>");
//				ProductDao dao = new ProductDaoMySQLImpl();
//				try {
//					List<Product> products = dao.getProducts();
//					for(Product p : products) {
//						 out.print("<tr>");
//						 	out.print("<td>" + p.getId()  +"</td>");
//						 	out.print("<td>" + p.getName()  +"</td>");
//						 	out.print("<td>" + p.getPrice()  +"</td>");
//						 	out.print("<td>" + p.getCategory()  +"</td>");
//						 out.print("</tr>");
//					}
//				} catch (DaoException e) {
//					e.printStackTrace();
//				}
//			out.print("</table>");
//		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // gets a character stream to browser
		ProductDao dao = new ProductDaoMySQLImpl();
		try {

			Product p = new Product(0, request.getParameter("name"), Double.parseDouble(request.getParameter("price")),
					request.getParameter("category"));
			dao.addProduct(p);
			out.println("Product added successfully!!");
		} catch (DaoException e) {
			e.printStackTrace();
		}

	}

}
