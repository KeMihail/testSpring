package by.itacademy.keikom.taxi.dao.dbmodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class OrderAssessment extends AbstractModel implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Order.class)
	private Order order;

	@Column
	private Integer assessment;

	@Column
	private String comment;

	public OrderAssessment() {

	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getAssessment() {
		return assessment;
	}

	public void setAssessment(Integer assessment) {
		this.assessment = assessment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
