package by.itacademy.keikom.taxi.services;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;

public interface IAuthenticationServices {

	Authentication save(Authentication authentication);

	void delete(Integer id);

	Authentication getById(Integer id);

	List<Authentication> getAll();

	List<Authentication> getAll(final String sortColumn, final boolean sortAscending, final int limit,
			final int offset);

	Integer getCount();
}
