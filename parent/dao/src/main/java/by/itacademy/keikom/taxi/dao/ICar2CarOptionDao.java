package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.dao.filter.Car2CarOptionFilter;

public interface ICar2CarOptionDao extends IHibernateDao<Car2CarOption, Integer> {

	void create(Car2CarOption obj);

	void delete(Car2CarOption obj);

	void update(Car2CarOption obj, Car2CarOption newObj);

	Car2CarOption getById(Car2CarOption obj);

	List<Integer> getOptionsByCar(Integer carId);

	List<Integer> getCarsByOption(Integer carOptionId);

	List<Car2CarOption> getAll();

	Long count(Car2CarOptionFilter filter);

	List<Car2CarOption> find(Car2CarOptionFilter filter);
}
