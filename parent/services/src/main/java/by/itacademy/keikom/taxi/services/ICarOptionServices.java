package by.itacademy.keikom.taxi.services;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.CarOption;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;

public interface ICarOptionServices {

	CarOption save(CarOption carOption);

	void delete(Integer id);

	CarOption getById(Integer id);

	List<CarOption> getAll();

}
