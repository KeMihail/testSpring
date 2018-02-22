package by.itacademy.keikom.taxi.web.dto;

import by.itacademy.keikom.taxi.dao.dbmodel.Car;

public class ServiceItemDTO {

	private Integer id;
	private Car car;
	private String item;
	private Double summa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
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
