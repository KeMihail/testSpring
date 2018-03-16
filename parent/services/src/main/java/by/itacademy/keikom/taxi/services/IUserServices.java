package by.itacademy.keikom.taxi.services;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.dao.filter.UserFilter;

public interface IUserServices {

	@Transactional
	void remove(Integer id);

	@Transactional
	User save(User user, UserAuthentication authentication);

	List<User> getAll();

	User get(Integer id);

	Long getCount(UserFilter filter);

	List<User> getAll(UserFilter filter);
}
