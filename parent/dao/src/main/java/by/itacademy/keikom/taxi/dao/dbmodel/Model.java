package by.itacademy.keikom.taxi.dao.dbmodel;

import by.itacademy.keikom.taxi.dao.enums.BodyType;
import by.itacademy.keikom.taxi.dao.enums.CarKit;
import by.itacademy.keikom.taxi.dao.enums.EngineType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Model implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column(name = "car_kit")
	private CarKit carCit;

	@Column
	private EngineType engineType;

	@Column
	private BodyType BodyType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Brand.class)
	private Brand brand;

	@Column
	private Timestamp created;

	@Column
	private Timestamp modified;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
	List<Car> cars;

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Model() {
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CarKit getCarCit() {
		return carCit;
	}

	public void setCarCit(CarKit carCit) {
		this.carCit = carCit;
	}

	public EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

	public BodyType getBodyType() {
		return BodyType;
	}

	public void setBodyType(BodyType eBodyType) {
		BodyType = eBodyType;
	}

	/*
	 * public Integer getBrandId() { return brandId; }
	 * 
	 * public void setBrandId(Integer brandId) { this.brandId = brandId; }
	 */

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
