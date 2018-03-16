package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import by.itacademy.keikom.taxi.dao.enums.UserRole;

@Entity
public class UserAuthentication implements Serializable {

	@Id
	private Integer userId;

	@Column(updatable = false)
	private Timestamp created;

	@Column
	private Timestamp modified;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "authentication")
	private User user;

	@Column
	private String login;

	@Column
	private String password;

	@Enumerated(value = EnumType.STRING)
	@Column
	private UserRole role;

	public Integer getUserId() {
		return userId;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public UserAuthentication() {
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
}
