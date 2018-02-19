package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Costs implements Serializable {

	@Id
	@Column
	private Integer carId;

	@Column
	private Double taxes;

	@Column
	private Double technicalInspection;

	@Column
	private Double insurance;

	@Column
	private Double carService;

	@Column
	private Double pretripInspection;

	@Column
	private Double salaryDriver;

	@Column
	private Double fuelConsumption;

	@Column
	private Double other;

	@Column
	private Timestamp created;

	@Column
	private Timestamp modified;

	public Costs() {
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

	@Override
	public String toString() {
		return "Costs [carId=" + carId + ", taxes=" + taxes + ", technicalInspection=" + technicalInspection
				+ ", insurance=" + insurance + ", carService=" + carService + ", pretripInspection=" + pretripInspection
				+ ", salaryDriver=" + salaryDriver + ", fuelCconsumption=" + fuelConsumption + ", other=" + other
				+ ", created=" + created + ", modified=" + modified + "]";
	}
}
