package by.itacademy.keikom.taxi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IUserAuthenticationDao;
import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;
import by.itacademy.keikom.taxi.services.IUserAuthenticationServices;

@Service
public class UserAuthenticationServicesImpl implements IUserAuthenticationServices {

	@Autowired
	private IUserAuthenticationDao dao;

	@Override
	public void remove(final Integer id) {
		dao.remove(id);

	}

	@Override
	public UserAuthentication save(final UserAuthentication authentication) {
		if (authentication.getUser() == null) {
			dao.insert(authentication);
		} else {
			dao.update(authentication);
		}
		return authentication;
	}

	@Override
	public List<UserAuthentication> getAll() {
		return dao.getAll();
	}

	@Override
	public UserAuthentication get(final Integer id) {
		return dao.get(id);
	}

	@Override
	public Long getCount(AuthenticationFilter filter) {
		return dao.count(filter);
	}

	@Override
	public List<UserAuthentication> getAll(AuthenticationFilter filter) {
		return dao.find(filter);
	}

	@Override
	public UserAuthentication loadByLogin(String login) {
		return dao.loadByLogin(login);
	}
}
