package by.itacademy.keikom.taxi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IAuthenticationUserDao;
import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;
import by.itacademy.keikom.taxi.services.IAuthenticationUserServices;

@Service
public class AuthenticationServicesImpl implements IAuthenticationUserServices {

	@Autowired
	private IAuthenticationUserDao dao;

	@Override
	public void remove(final Integer id) {
		dao.remove(id);

	}

	@Override
	public AuthenticationUser save(final AuthenticationUser authentication) {
		if (authentication.getUser() == null) {
			dao.insert(authentication);
		} else {
			dao.update(authentication);
		}
		return authentication;
	}

	@Override
	public List<AuthenticationUser> getAll() {
		return dao.getAll();
	}

	@Override
	public AuthenticationUser get(final Integer id) {
		return dao.get(id);
	}

	@Override
	public Long getCount(AuthenticationFilter filter) {
		return dao.count(filter);
	}

	@Override
	public List<AuthenticationUser> getAll(AuthenticationFilter filter) {
		return dao.find(filter);
	}

	@Override
	public AuthenticationUser loadByLogin(String login) {
		return dao.loadByLogin(login);
	}
}
