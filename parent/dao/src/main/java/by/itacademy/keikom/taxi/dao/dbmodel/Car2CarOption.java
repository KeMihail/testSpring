package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car2CarOption implements Serializable {

	@Id
	private Integer carId;
	@Column
	private Integer carOptionId;

	public Car2CarOption() {
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getCarOptionId() {
		return carOptionId;
	}

	public void setCarOptionId(Integer carOptionId) {
		this.carOptionId = carOptionId;
	}

	@Override
	public String toString() {
		return "Car2CarOption [carId=" + carId + ", carOptionId=" + carOptionId + "]";
	}
}
