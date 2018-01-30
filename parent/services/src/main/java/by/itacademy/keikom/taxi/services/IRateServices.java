package by.itacademy.keikom.taxi.services;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Rate;

public interface IRateServices {
	Rate save(Rate rate);

	void delete(Integer id);

	Rate getById(Integer id);

	public List<Rate> getAll();

	public List<Rate> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset);

	public Integer getCount();
}
