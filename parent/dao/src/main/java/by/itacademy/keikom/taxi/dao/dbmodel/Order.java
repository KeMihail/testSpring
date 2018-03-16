package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	private Integer rateId;

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private Car car;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<OrderAssessment> orderAssessments;

	public Order() {
	}

	public Integer getRateId() {
		return rateId;
	}

	public void setRateId(Integer rateId) {
		this.rateId = rateId;
	}

	public List<OrderAssessment> getOrderAssessments() {
		return orderAssessments;
	}

	public void setOrderAssessments(List<OrderAssessment> orderAssessments) {
		this.orderAssessments = orderAssessments;
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
