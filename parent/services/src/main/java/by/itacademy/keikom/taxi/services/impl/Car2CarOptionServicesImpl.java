package by.itacademy.keikom.taxi.services.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.ICar2CarOptionDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.filter.Car2CarOptionFilter;
import by.itacademy.keikom.taxi.services.ICar2CarOptionServices;

@Service
public class Car2CarOptionServicesImpl implements ICar2CarOptionServices {

	@Autowired
	private ICar2CarOptionDao dao;

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Car2CarOption save(Car2CarOption car2CarOption) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car2CarOption> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car2CarOption get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCount(Car2CarOptionFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car2CarOption> getAll(Car2CarOptionFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
