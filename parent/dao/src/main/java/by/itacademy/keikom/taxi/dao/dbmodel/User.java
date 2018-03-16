package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import by.itacademy.keikom.taxi.dao.enums.UserRole;

@Entity
public class User extends AbstractModel implements Serializable {

	@Column
	private String name;

	@Column
	private String lastName;

	@Column
	private Timestamp birthday;

	@Column
	private String address;

	@Column
	private String phoneNumber;

	@Column
	private String email;

	@Column
	private Boolean deleted;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@PrimaryKeyJoinColumn
	private UserAuthentication authentication;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Order> orders;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Car> cars;

	public User() {
	}

	public UserAuthentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(UserAuthentication authentication) {
		this.authentication = authentication;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
