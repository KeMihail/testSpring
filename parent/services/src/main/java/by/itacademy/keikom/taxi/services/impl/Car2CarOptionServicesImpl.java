package by.itacademy.keikom.taxi.services.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.ICar2CarOptionDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.services.ICar2CarOptionServices;

@Service
public class Car2CarOptionServicesImpl implements ICar2CarOptionServices {

	@Autowired
	private ICar2CarOptionDao dao;

	@Override
	public Car2CarOption create(Car2CarOption obj) {
		dao.create(obj);
		return obj;
	}

	@Override
	public void update(Car2CarOption obj, Car2CarOption newObj) {
		dao.update(obj, newObj);
	}

	@Override
	public void delete(Car2CarOption obj) {
		dao.delete(obj);
	}

	@Override
	public List<Integer> getByIdOption(Integer carId) {
		return dao.getOptionsByCar(carId);
	}

	@Override
	public List<Integer> getByIdCar(Integer carOptionId) {
		return dao.getCarsByOption(carOptionId);
	}

	@Override
	public List<Car2CarOption> getAll() {
		return dao.getAll();
	}

	@Override
	public Car2CarOption getById(Car2CarOption obj) {
		return dao.getById(obj);
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<Car2CarOption> getAll(final String sortColumn, final boolean sortAscending, final int limit,
			final int offset) {
		final List<Car2CarOption> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<Car2CarOption>() {
			@Override
			public int compare(Car2CarOption o1, Car2CarOption o2) {
				if (sortAscending) {
					final Car2CarOption temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("carId".equals(sortColumn)) {
					return o1.getCarId().compareTo(o2.getCarId());
				} else if ("carOptionId".equals(sortColumn)) {
					return o1.getCarOptionId().compareTo(o2.getCarOptionId());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
