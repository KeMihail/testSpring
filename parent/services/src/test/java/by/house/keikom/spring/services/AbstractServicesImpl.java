package by.house.keikom.spring.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import by.house.keikom.spring.dao.dbmodel.Product;
import by.house.keikom.spring.dao.dbmodel.User;

public abstract class AbstractServicesImpl {

	public Product createProduct() {
		Product product = new Product();
		product.setName("Мороженое");
		product.setManufacturer("ОАО Молочный Мир");
		product.setPrice(50.0);
		product.setDeleted(false);
		return product;
	}

	public User createUser() throws ParseException {
		User user = new User();
		user.setName("Миша");
		user.setLastName("Кейко");

		Calendar date = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		date.setTime(format.parse("1984-07-28"));
		user.setBirthday(new Timestamp(date.getTimeInMillis()));

		user.setPhone_number("80297875512");
		user.setEmail("Miha@tut.by");
		user.setDeleted(false);
		return user;
	}
}
