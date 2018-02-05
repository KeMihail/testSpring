package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.ICarDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Car;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.services.ICarServices;

@Service
public class CarServicesImpl implements ICarServices {

	@Autowired
	private ICarDao dao;

	@Override
	public Car save(Car car) {
		car.setModified(new Timestamp(new Date().getTime()));

		if (car.getId() != null) {
			dao.update(car);
		} else {
			car.setCreated(new Timestamp(new Date().getTime()));
			Integer id = dao.create(car);
			car.setId(id);
		}
		return car;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Car getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Car> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<Car> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset) {
		final List<Car> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				if (sortAscending) {
					final Car temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("id".equals(sortColumn)) {
					return o1.getId().compareTo(o2.getId());
				} else if ("userId".equals(sortColumn)) {
					return o1.getUserId().compareTo(o2.getUserId());
				} else if ("releaseYear".equals(sortColumn)) {
					return o1.getReleaseYear().compareTo(o2.getReleaseYear());
				} else if ("modelId".equals(sortColumn)) {
					return o1.getModelId().compareTo(o2.getModelId());
				} else if ("legalEntityId".equals(sortColumn)) {
					return o1.getLegalEntityId().compareTo(o2.getLegalEntityId());
				} else if ("status".equals(sortColumn)) {
					return o1.getStatus().compareTo(o2.getStatus());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
