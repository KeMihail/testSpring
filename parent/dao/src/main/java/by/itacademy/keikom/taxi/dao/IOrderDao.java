package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Order;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.filter.OrderFilter;
import by.itacademy.keikom.taxi.dao.filter.RateFilter;

public interface IOrderDao extends IHibernateDao<Order, Integer> {

	Long count(OrderFilter filter);

	List<Order> find(OrderFilter filter);
}
