package by.house.keikom.spring.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.house.keikom.spring.dao.IUserDao;
import by.house.keikom.spring.dao.dbmodel.User;
import by.house.keikom.spring.services.IUserServices;

@Service
public class UserServicesImpl implements IUserServices {

	@Autowired
	private IUserDao dao;

	@Override
	public User save(User user) {

		user.setModified(new Timestamp(new Date().getTime()));

		if (user.getId() != null) {
			dao.update(user);
		} else {
			user.setCreated(new Timestamp(new Date().getTime()));
			Integer id = dao.create(user);
			user.setId(id);
		}
		return null;
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
}
