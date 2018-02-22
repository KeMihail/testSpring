package by.itacademy.keikom.taxi.web.dto;

import java.sql.Timestamp;

import by.itacademy.keikom.taxi.dao.dbmodel.User;

public class AuthenticationDTO {

	private User user;
	private String login;
	private String password;
	private Timestamp created;
	private Timestamp modified;

	public AuthenticationDTO() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

}
