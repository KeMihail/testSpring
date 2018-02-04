package by.itacademy.keikom.taxi.web.dto;

import java.sql.Timestamp;

public class ModelDTO {

	private Integer id;
	private String name;
	private String carCit;
	private String engineType;
	private String BodyType;
	private Integer brandId;
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
		return BodyType;
	}

	public void setBodyType(String eBodyType) {
		BodyType = eBodyType;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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
