package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import by.itacademy.keikom.taxi.dao.enums.EServiceItem;

@Entity
public class ServiceItem extends AbstractModel implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private Car car;

	@Column
	@Enumerated(value = EnumType.STRING)
	private EServiceItem item;

	@Column
	private Double summa;

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

	public EServiceItem getItem() {
		return item;
	}

	public void setItem(EServiceItem item) {
		this.item = item;
	}
}
