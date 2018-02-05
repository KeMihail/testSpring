package by.itacademy.keikom.taxi.services;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;

public interface ICar2CarOptionServices {

	Car2CarOption create(Car2CarOption obj);

	void update(Car2CarOption obj, Car2CarOption newObj);

	void delete(Car2CarOption obj);

	List<Integer> getByIdOption(Integer carId);

	List<Integer> getByIdCar(Integer carOptionId);

	List<Car2CarOption> getAll();

	Car2CarOption getById(Car2CarOption obj);

	public List<Car2CarOption> getAll(final String sortColumn, final boolean sortAscending, final int limit,
			final int offset);

	public Integer getCount();
}
