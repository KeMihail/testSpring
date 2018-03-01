package by.itacademy.keikom.taxi.web.dto;

import by.itacademy.keikom.taxi.dao.dbmodel.Car;

public class ServiceItemDTO {

	private Integer id;
	private Integer carId;
	private String item;
	private Double summa;

	public Integer getId() {
		return id;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSumma() {
		return summa;
	}

	public void setSumma(Double summa) {
		this.summa = summa;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
