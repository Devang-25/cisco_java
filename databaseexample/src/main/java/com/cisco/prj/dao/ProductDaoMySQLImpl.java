package com.cisco.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cisco.prj.entity.Product;

public class ProductDaoMySQLImpl implements ProductDao {
	private static Logger logger = LoggerFactory.getLogger(ProductDaoMySQLImpl.class);
	
	private static String DRIVER = "";
	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";

	// static blocks gets executed automatically when class is loaded
	// and executes only once
	static {
		ResourceBundle res = ResourceBundle.getBundle("config"); // config.properties
		DRIVER = res.getString("DRIVER");
		URL = res.getString("URL");
		USER = res.getString("USER");
		PASSWORD = res.getString("PASSWORD");

		try {
			Class.forName(DRIVER); // load database vendor classes
			
	        logger.info("Drivers loaded!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(Product p) throws DaoException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String SQL = "INSERT INTO products (id, name, price, category) VALUES (0,?,?,?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getCategory());
			ps.executeUpdate(); // INSERT, DELETE and UPDATE
		} catch (SQLException e) {
//			e.printStackTrace();
			 logger.error("unable to add product");
			throw new DaoException("unable to add product", e);
	       
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Product> getProducts() throws DaoException{
		List<Product> products = new ArrayList<>();
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM products");
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), 
							rs.getString("name"), 
							rs.getDouble("price"),
						rs.getString("category"));
				products.add(p); // add product to collection
			}
		} catch (SQLException e) {
			throw new DaoException("unable to get products", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products; // return the products collection
	}

}
