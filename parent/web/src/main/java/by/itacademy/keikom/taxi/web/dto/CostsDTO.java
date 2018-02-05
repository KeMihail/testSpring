package by.itacademy.keikom.taxi.web.dto;

import java.sql.Timestamp;

public class CostsDTO {

	private Integer carId;
	private Double taxes;
	private Double technicalInspection;
	private Double insurance;
	private Double carService;
	private Double pretripInspection;
	private Double salaryDriver;
	private Double fuelConsumption;
	private Double other;
	private Timestamp created;
	private Timestamp modified;

	public CostsDTO() {
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public Double getTechnicalInspection() {
		return technicalInspection;
	}

	public void setTechnicalInspection(Double technicalInspection) {
		this.technicalInspection = technicalInspection;
	}

	public Double getInsurance() {
		return insurance;
	}

	public void setInsurance(Double insurance) {
		this.insurance = insurance;
	}

	public Double getCarService() {
		return carService;
	}

	public void setCarService(Double carService) {
		this.carService = carService;
	}

	public Double getPretripInspection() {
		return pretripInspection;
	}

	public void setPretripInspection(Double pretripInspection) {
		this.pretripInspection = pretripInspection;
	}

	public Double getSalaryDriver() {
		return salaryDriver;
	}

	public void setSalaryDriver(Double salaryDriver) {
		this.salaryDriver = salaryDriver;
	}

	public Double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(Double fuelCconsumption) {
		this.fuelConsumption = fuelCconsumption;
	}

	public Double getOther() {
		return other;
	}

	public void setOther(Double other) {
		this.other = other;
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
