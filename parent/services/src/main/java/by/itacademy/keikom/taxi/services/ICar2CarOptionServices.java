package by.itacademy.keikom.taxi.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.dao.filter.Car2CarOptionFilter;

public interface ICar2CarOptionServices {

	@Transactional
	void remove(Integer id);

	@Transactional
	Car2CarOption save(Car2CarOption car2CarOption);

	List<Car2CarOption> getAll();

	Car2CarOption get(Integer id);

	Long getCount(Car2CarOptionFilter filter);

	List<Car2CarOption> getAll(Car2CarOptionFilter filter);
}
