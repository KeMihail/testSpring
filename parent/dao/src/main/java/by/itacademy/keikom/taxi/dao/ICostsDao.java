package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Costs;

public interface ICostsDao {

	void create(Costs costs);

	void delete(Integer id);

	void update(Costs costs);

	Costs getById(Integer id);

	List<Costs> getAll();
}
