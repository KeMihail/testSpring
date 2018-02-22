package by.itacademy.keikom.taxi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IAuthenticationDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;
import by.itacademy.keikom.taxi.services.IAuthenticationServices;

@Service
public class AuthenticationServicesImpl implements IAuthenticationServices {

	@Autowired
	private IAuthenticationDao dao;

	@Override
	public void remove(final Integer id) {
		dao.remove(id);

	}

	@Override
	public Authentication save(final Authentication authentication) {
		if (authentication.getUser() == null) {
			dao.insert(authentication);
		} else {
			dao.update(authentication);
		}
		return authentication;
	}

	@Override
	public List<Authentication> getAll() {
		return dao.getAll();
	}

	@Override
	public Authentication get(final Integer id) {
		return dao.get(id);
	}

	@Override
	public Long getCount(AuthenticationFilter filter) {
		return dao.count(filter);
	}

	@Override
	public List<Authentication> getAll(AuthenticationFilter filter) {
		return dao.find(filter);
	}
}
