package by.itacademy.keikom.taxi.services;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.Brand;

public interface IBrandServices {

	@Transactional
	Brand save(Brand brand);

	@Transactional
	void delete(Integer id);

	Brand getById(Integer id);

	public List<Brand> getAll();

	public List<Brand> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset);

	public Integer getCount();
}
