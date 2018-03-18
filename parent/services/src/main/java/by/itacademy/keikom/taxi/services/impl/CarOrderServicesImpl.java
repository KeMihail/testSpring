package by.itacademy.keikom.taxi.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.ICarOrderDao;
import by.itacademy.keikom.taxi.dao.dbmodel.CarOrder;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.filter.CarOrderFilter;
import by.itacademy.keikom.taxi.services.ICarOrderServices;
import by.itacademy.keikom.taxi.services.IUserServices;

@Service
public class CarOrderServicesImpl implements ICarOrderServices {

	@Autowired
	private ICarOrderDao dao;
	@Autowired
	private IUserServices userService;

	@Override
	public void remove(Integer id) {
		dao.remove(id);
	}

	@Override
	public CarOrder save(CarOrder order) {

		order.setDeleted(false);

		if (order.getId() == null) {
			order.setOrderBegin(new Date());

			dao.insert(order);
		} else {

			Rate rate = order.getRate();
			Double landing = rate.getPriceLanding();
			Double priceKilometr = rate.getPriceKilometr() * order.getDistanceOrder();
			Double wait = rate.getPriceMinuteWait() * order.getInactivityMinutes();

			order.setTotal(landing + priceKilometr + wait);

			order.setOrderEnd(new Date());
			dao.update(order);
		}
		return order;
	}

	@Override
	public List<CarOrder> getAll() {

		return dao.getAll();
	}

	@Override
	public CarOrder get(Integer id) {
		return dao.get(id);
	}

	@Override
	public Long getCount(CarOrderFilter filter) {
		return dao.count(filter);
	}

	@Override
	public List<CarOrder> getAll(CarOrderFilter filter) {
		return dao.find(filter);
	}

}
