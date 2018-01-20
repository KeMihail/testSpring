package by.house.keikom.spring.dao.dbmodel;

import java.sql.Timestamp;

public class Order {

	private Integer id;
	private Integer userId;
	private Timestamp orderDate;
	private Timestamp executionOrder;
	private Double summ;
	private Boolean deleted;
	private Timestamp created;
	private Timestamp modified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getExecutionOrder() {
		return executionOrder;
	}

	public void setExecutionOrder(Timestamp executionOrder) {
		this.executionOrder = executionOrder;
	}

	public Double getSumm() {
		return summ;
	}

	public void setSumm(Double summ) {
		this.summ = summ;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
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
