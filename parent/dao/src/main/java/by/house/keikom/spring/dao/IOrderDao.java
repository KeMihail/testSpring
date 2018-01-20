package by.house.keikom.spring.dao;

import java.util.List;

import by.house.keikom.spring.dao.dbmodel.Order;

public interface IOrderDao {

	Integer create(Order order);

	void delete(Integer id);

	void update(Order order);

	Order getById(Integer id);

	List<Order> getAll();
}
