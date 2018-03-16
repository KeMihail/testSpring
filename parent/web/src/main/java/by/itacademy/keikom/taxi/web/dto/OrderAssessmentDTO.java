package by.itacademy.keikom.taxi.web.dto;

import java.sql.Timestamp;

import javax.persistence.Column;

import by.itacademy.keikom.taxi.dao.dbmodel.Order;

public class OrderAssessmentDTO {

	private Integer id;
	private Integer orderId;
	private Integer assessment;
	private String comment;

	private Timestamp created;
	private Timestamp modified;

	public OrderAssessmentDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
