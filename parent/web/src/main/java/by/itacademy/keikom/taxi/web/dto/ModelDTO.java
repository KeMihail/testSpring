package by.itacademy.keikom.taxi.web.dto;

import java.sql.Timestamp;

import by.itacademy.keikom.taxi.dao.dbmodel.Brand;

public class ModelDTO {

	private Integer id;
	private String name;
	private String carCit;
	private String engineType;
	private String bodyType;

	private Brand brand;
	private Timestamp created;
	private Timestamp modified;

	public ModelDTO() {
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

	public String getCarCit() {
		return carCit;
	}

	public void setCarCit(String carCit) {
		this.carCit = carCit;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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
