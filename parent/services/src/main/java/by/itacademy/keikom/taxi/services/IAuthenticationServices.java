package by.itacademy.keikom.taxi.services;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;

public interface IAuthenticationServices {

	@Transactional
	void remove(Integer id);

	@Transactional
	Authentication save(Authentication authentication);

	List<Authentication> getAll();

	Authentication get(Integer id);

	Long getCount(AuthenticationFilter filter);

	List<Authentication> getAll(AuthenticationFilter filter);
}
