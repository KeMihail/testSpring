package by.itacademy.keikom.taxi.dao.dbmodel;

import by.itacademy.keikom.taxi.dao.enums.BodyType;
import by.itacademy.keikom.taxi.dao.enums.CarKit;
import by.itacademy.keikom.taxi.dao.enums.EngineType;

import java.sql.Timestamp;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

public class Model {

	/*
	 * @ManyToOne(fetch = FetchType.LAZY) private Brand brand;
	 */

	private Integer id;
	private String name;
	private CarKit carCit;
	private EngineType engineType;
	private BodyType BodyType;
	private Integer brandId;
	private Timestamp created;
	private Timestamp modified;

	public Model() {
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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
