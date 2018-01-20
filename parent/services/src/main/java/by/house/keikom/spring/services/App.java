package by.house.keikom.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.house.keikom.spring.dao.dbmodel.Product;
import by.house.keikom.spring.services.impl.ProductServicesImpl;

public class App {

	public static void main(String[] args) throws ParseException {

		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("context.xml");
		 * System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		 */

		/*
		 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); Calendar date =
		 * Calendar.getInstance(); date.set(1984, 5, 30);
		 * System.out.println(format.format(date.getTime()));
		 * 
		 * Calendar cal = new GregorianCalendar(); System.out.println(cal.getTime());
		 * 
		 * Date d = new Date(); System.out.println(d.getTime());
		 */

		String dat = "1984-07-28";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(format.parse(dat));
		System.out.println(format.format(cal.getTime()));
	}
}
