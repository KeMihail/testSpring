package by.itacademy.keikom.taxi.services;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;

public interface ICostsServices {

	Costs save(Costs costs);

	void delete(Integer id);

	Costs getById(Integer id);

	List<Costs> getAll();

	public List<Costs> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset);

	public Integer getCount();
}
