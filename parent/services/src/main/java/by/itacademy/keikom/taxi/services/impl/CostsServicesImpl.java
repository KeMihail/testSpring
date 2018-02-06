package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.ICostsDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.filter.CostsFilter;
import by.itacademy.keikom.taxi.services.ICostsServices;

@Service
public class CostsServicesImpl implements ICostsServices {

	@Autowired
	private ICostsDao dao;

	@Override
	public void remove(final Integer id) {
		dao.remove(id);

	}

	@Override
	public Costs save(final Costs costs) {
		if (costs.getCarId() == null) {
			dao.insert(costs);
		} else {
			dao.update(costs);
		}
		return costs;
	}

	@Override
	public List<Costs> getAll() {
		return dao.getAll();
	}

	@Override
	public Costs get(final Integer id) {
		return dao.get(id);
	}

	@Override
	public Long getCount(CostsFilter filter) {
		return dao.count(filter);
	}

	@Override
	public List<Costs> getAll(CostsFilter filter) {
		return dao.find(filter);
	}
}
