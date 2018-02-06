package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IUserDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.filter.UserFilter;
import by.itacademy.keikom.taxi.dao.impl.UserDaoImpl;
import by.itacademy.keikom.taxi.services.IUserServices;
import by.itacademy.keikom.taxi.services.exeption.NotValidBirthdayException;
import by.itacademy.keikom.taxi.services.exeption.NotValidPhoneNumberException;

@Service
public class UserServicesImpl extends AbstractServicesImpl implements IUserServices {

	@Autowired
	private IUserDao dao;

	/*
	 * if (!validateEmailAddress(user.getEmail())) { user.setEmail(null); }
	 * 
	 * if (!validatePhoneNumber(user.getPhoneNumber())) { throw new
	 * NotValidPhoneNumberException(); }
	 * 
	 * if (!validateBirthday(user.getBirthday().toString())) { throw new
	 * NotValidBirthdayException(); }
	 */

	@Override
	public void remove(final Integer id) {
		dao.remove(id);

	}

	@Override
	public User save(final User user) {
		if (user.getId() == null) {
			dao.insert(user);
		} else {
			dao.update(user);
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		return dao.getAll();
	}

	@Override
	public User get(final Integer id) {
		return dao.get(id);
	}

	@Override
	public Long getCount(UserFilter filter) {
		return dao.count(filter);
	}

	@Override
	public List<User> getAll(UserFilter filter) {
		return dao.find(filter);
	}
}
