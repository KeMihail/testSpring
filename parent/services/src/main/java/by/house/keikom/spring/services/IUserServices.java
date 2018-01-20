package by.house.keikom.spring.services;

import java.util.List;

import by.house.keikom.spring.dao.dbmodel.User;

public interface IUserServices {

	User save(User user);

	void delete(Integer id);

	User getById(Integer id);

	List<User> getAll();
}
