package by.house.keikom.spring.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import by.house.keikom.spring.dao.dbmodel.Product;

public class Test {

	public static void main(String[] args) throws SQLException {

		Product product = new Product();
		product.setName("Мороженое");
		product.setManufacturer("ООО Молочный Мир");
		product.setPrice(50.0);
		product.setCreated(new Timestamp(new Date().getTime()));
		product.setModified(new Timestamp(new Date().getTime()));
	}
}
