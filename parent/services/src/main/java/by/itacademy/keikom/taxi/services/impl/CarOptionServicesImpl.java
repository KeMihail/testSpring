package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.ICarOptionDao;
import by.itacademy.keikom.taxi.dao.dbmodel.CarOption;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.services.ICarOptionServices;

@Service
public class CarOptionServicesImpl implements ICarOptionServices {

	@Autowired
	private ICarOptionDao dao;

	@Override
	public CarOption save(CarOption carOption) {

		carOption.setModified(new Timestamp(new Date().getTime()));

		if (carOption.getId() != null) {
			dao.update(carOption);
		} else {
			carOption.setCreated(new Timestamp(new Date().getTime()));
			Integer id = dao.create(carOption);
			carOption.setId(id);
		}
		return carOption;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public CarOption getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<CarOption> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<CarOption> getAll(final String sortColumn, final boolean sortAscending, final int limit,
			final int offset) {
		final List<CarOption> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<CarOption>() {
			@Override
			public int compare(CarOption o1, CarOption o2) {
				if (sortAscending) {
					final CarOption temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("id".equals(sortColumn)) {
					return o1.getId().compareTo(o2.getId());
				} else if ("name".equals(sortColumn)) {
					return o1.getName().compareTo(o2.getName());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
