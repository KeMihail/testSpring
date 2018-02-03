package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column
	private Double priceLanding;
	@Column
	private Double priceKilometr;
	@Column
	private Double priceMinuteWait;

	@Column(updatable = false)
	private Timestamp created;
	@Column
	private Timestamp modified;

	public Rate() {
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

	public Double getPriceLanding() {
		return priceLanding;
	}

	public void setPriceLanding(Double priceLanding) {
		this.priceLanding = priceLanding;
	}

	public Double getPriceKilometr() {
		return priceKilometr;
	}

	public void setPriceKilometr(Double priceKilometr) {
		this.priceKilometr = priceKilometr;
	}

	public Double getPriceMinuteWait() {
		return priceMinuteWait;
	}

	public void setPriceMinuteWait(Double priceMinuteWait) {
		this.priceMinuteWait = priceMinuteWait;
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
		return "Rate [id=" + id + ", name=" + name + ", priceLanding=" + priceLanding + ", priceKilometr="
				+ priceKilometr + ", priceMinuteWait=" + priceMinuteWait + ", created=" + created + ", modified="
				+ modified + "]";
	}
}
