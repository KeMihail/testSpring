package by.itacademy.keikom.taxi.web.dto;

import java.sql.Timestamp;

import by.itacademy.keikom.taxi.dao.dbmodel.User;

public class UserAuthenticationDTO {

	private Integer userId;
	private String login;
	private String password;
	private String role;
	private Timestamp created;
	private Timestamp modified;

	public UserAuthenticationDTO() {
	}

	public Integer getUserId() {
		return userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
