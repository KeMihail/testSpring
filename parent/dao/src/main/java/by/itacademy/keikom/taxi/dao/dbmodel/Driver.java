package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import by.itacademy.keikom.taxi.dao.enums.Role;

@Entity
public class Driver extends AbstractUser implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private Car car;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
	private List<CarOrder> callsDriver;

	public Driver() {

	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<CarOrder> getCallsDriver() {
		return callsDriver;
	}

	public void setCallsDriver(List<CarOrder> callsDriver) {
		this.callsDriver = callsDriver;
	}

}
