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
import by.itacademy.keikom.taxi.dao.impl.UserDaoImpl;
import by.itacademy.keikom.taxi.services.IUserServices;
import by.itacademy.keikom.taxi.services.exeption.NotValidBirthdayException;
import by.itacademy.keikom.taxi.services.exeption.NotValidPhoneNumberException;

@Service
public class UserServicesImpl extends AbstractServicesImpl implements IUserServices {

	@Autowired
	private IUserDao dao;

	@Override
	public User save(User user) {

		/*
		 * if (!validateEmailAddress(user.getEmail())) { user.setEmail(null); }
		 * 
		 * if (!validatePhoneNumber(user.getPhoneNumber())) { throw new
		 * NotValidPhoneNumberException(); }
		 * 
		 * if (!validateBirthday(user.getBirthday().toString())) { throw new
		 * NotValidBirthdayException(); }
		 */

		user.setModified(new Timestamp(new Date().getTime()));

		if (user.getId() != null) {
			dao.update(user);
		} else {
			user.setCreated(new Timestamp(new Date().getTime()));
			Integer id = dao.create(user);
			user.setId(id);
			;
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public User getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<User> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<User> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset) {
		final List<User> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				if (sortAscending) {
					final User temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("id".equals(sortColumn)) {
					return o1.getId().compareTo(o2.getId());
				} else if ("name".equals(sortColumn)) {
					return o1.getName().compareTo(o2.getName());
				} else if ("lastName".equals(sortColumn)) {
					return o1.getLastName().compareTo(o2.getLastName());
				} else if ("birthday".equals(sortColumn)) {
					return o1.getBirthday().compareTo(o2.getBirthday());
				} else if ("address".equals(sortColumn)) {
					return o1.getAddress().compareTo(o2.getAddress());
				} else if ("phoneNumber".equals(sortColumn)) {
					return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
				} else if ("email".equals(sortColumn)) {
					return o1.getEmail().compareTo(o2.getEmail());
				} else if ("role".equals(sortColumn)) {
					return o1.getRole().compareTo(o2.getRole());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
