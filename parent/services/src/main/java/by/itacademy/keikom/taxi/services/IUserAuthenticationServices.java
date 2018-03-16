package by.itacademy.keikom.taxi.services;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;

public interface IUserAuthenticationServices {

	@Transactional
	void remove(Integer id);

	@Transactional
	UserAuthentication save(UserAuthentication authentication);

	List<UserAuthentication> getAll();

	UserAuthentication get(Integer id);

	Long getCount(AuthenticationFilter filter);

	List<UserAuthentication> getAll(AuthenticationFilter filter);

	UserAuthentication loadByLogin(String login);
}
