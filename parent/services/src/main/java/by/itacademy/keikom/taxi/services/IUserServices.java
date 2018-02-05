package by.itacademy.keikom.taxi.services;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.User;

public interface IUserServices {

	User save(User user);

	void delete(Integer id);

	User getById(Integer id);

	List<User> getAll();

	public List<User> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset);

	public Integer getCount();
}
