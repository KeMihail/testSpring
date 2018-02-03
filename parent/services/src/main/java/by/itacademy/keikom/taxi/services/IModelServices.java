package by.itacademy.keikom.taxi.services;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.Model;

public interface IModelServices {

	@Transactional
	Model save(Model model);

	@Transactional
	void delete(Integer id);

	Model getById(Integer id);

	public List<Model> getAll();

	public List<Model> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset);

	public Integer getCount();
}
