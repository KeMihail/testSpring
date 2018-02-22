package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;

import by.itacademy.keikom.taxi.dao.enums.CarStatus;

@Entity
public class Car extends AbstractModel implements Serializable {

	@Column
	private Integer releaseYear;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CarStatus status;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Model.class)
	private Model model;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = LegalEntity.class)
	private LegalEntity legalEntity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	private List<Order> orders;

	/*
	 * @OneToOne(fetch = FetchType.LAZY)
	 * 
	 * @PrimaryKeyJoinColumn private Costs costs;
	 */

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = CarOption.class)
	@JoinTable(name = "car_2_car_option", joinColumns = { @JoinColumn(name = "car_id") }, inverseJoinColumns = {
			@JoinColumn(name = "car_option_id") })
	@OrderBy("name ASC")
	private Set<CarOption> carOption;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	private Set<ServiceItem> serviceItem;

	public Car() {
	}

	public Set<CarOption> getCarOption() {
		return carOption;
	}

	public void setCarOption(Set<CarOption> carOption) {
		this.carOption = carOption;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public CarStatus getStatus() {
		return status;
	}

	public void setStatus(CarStatus status) {
		this.status = status;
	}

	public Set<ServiceItem> getServiceItem() {
		return serviceItem;
	}

	public void setServiceItem(Set<ServiceItem> serviceItem) {
		this.serviceItem = serviceItem;
	}
}
