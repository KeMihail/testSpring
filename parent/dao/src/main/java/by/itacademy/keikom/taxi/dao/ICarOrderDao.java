package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.CarOrder;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.filter.CarOrderFilter;
import by.itacademy.keikom.taxi.dao.filter.RateFilter;

public interface ICarOrderDao extends IHibernateDao<CarOrder, Integer> {

	Long count(CarOrderFilter filter);

	List<CarOrder> find(CarOrderFilter filter);
}
