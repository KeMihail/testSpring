package by.itacademy.keikom.taxi.services;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;

public interface IAuthenticationUserServices {

	@Transactional
	void remove(Integer id);

	@Transactional
	AuthenticationUser save(AuthenticationUser authentication);

	List<AuthenticationUser> getAll();

	AuthenticationUser get(Integer id);

	Long getCount(AuthenticationFilter filter);

	List<AuthenticationUser> getAll(AuthenticationFilter filter);

	AuthenticationUser loadByLogin(String login);
}
