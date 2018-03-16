package by.itacademy.keikom.taxi.services;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.Order;
import by.itacademy.keikom.taxi.dao.filter.OrderFilter;

public interface IOrderServices {

	@Transactional
	void remove(Integer id);

	@Transactional
	Order save(Order order);

	List<Order> getAll();

	Order get(Integer id);

	Long getCount(OrderFilter filter);

	List<Order> getAll(OrderFilter filter);
}
