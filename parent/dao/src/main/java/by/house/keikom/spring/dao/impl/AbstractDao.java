package by.house.keikom.spring.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

public class AbstractDao {

	@Value("jdbc:mysql://${host}:${port}/${dbName}?useSSL=false")
	private String dbURL;

	@Value("${login}")
	private String dbLogin;

	@Value("${password}")
	private String dbPassword;

	@PostConstruct
	public void unit() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(dbURL, dbLogin, dbPassword);
	}
}
