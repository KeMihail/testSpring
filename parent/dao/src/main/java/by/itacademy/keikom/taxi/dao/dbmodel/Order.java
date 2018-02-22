package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Order extends AbstractModel implements Serializable {

	@Column
	private String departureAddress;

	@Column
	private String arrivalAddress;

	@Column
	private Timestamp orderBegin;

	@Column
	private Timestamp orderEnd;

	@Column
	private Double distanceOrder;

	@Column
	private Double distancePaid;

	@Column
	private Integer inactivityMinutes;

	@Column
	private Double summ;

	@Column
	private Boolean deleted;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Rate.class)
	private Rate rate;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private Car car;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	private User user;

	public Order() {
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDepartureAddress() {
		return departureAddress;
	}

	public void setDepartureAddress(String departureAddress) {
		this.departureAddress = departureAddress;
	}

	public String getArrivalAddress() {
		return arrivalAddress;
	}

	public void setArrivalAddress(String arrivalAddress) {
		this.arrivalAddress = arrivalAddress;
	}

	public Timestamp getOrderBegin() {
		return orderBegin;
	}

	public void setOrderBegin(Timestamp orderBegin) {
		this.orderBegin = orderBegin;
	}

	public Timestamp getOrderEnd() {
		return orderEnd;
	}

	public void setOrderEnd(Timestamp orderEnd) {
		this.orderEnd = orderEnd;
	}

	public Double getDistanceOrder() {
		return distanceOrder;
	}

	public void setDistanceOrder(Double distanceOrder) {
		this.distanceOrder = distanceOrder;
	}

	public Double getDistancePaid() {
		return distancePaid;
	}

	public void setDistancePaid(Double distancePaid) {
		this.distancePaid = distancePaid;
	}

	public Integer getInactivityMinutes() {
		return inactivityMinutes;
	}

	public void setInactivityMinutes(Integer inactivityMinutes) {
		this.inactivityMinutes = inactivityMinutes;
	}

	public Double getSumm() {
		return summ;
	}

	public void setSumm(Double summ) {
		this.summ = summ;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
