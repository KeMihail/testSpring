package by.itacademy.keikom.taxi.services;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Car;

public interface ICarServices {

	Car save(Car car);

	void delete(Integer id);

	Car getById(Integer id);

	List<Car> getAll();

	public List<Car> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset);

	public Integer getCount();
}
