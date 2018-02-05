package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;

public interface IAuthenticationDao {

	void create(Authentication authentication);

	void delete(Integer id);

	void update(Authentication authentication);

	public Authentication getById(Integer id);

	public List<Authentication> getAll();
}
