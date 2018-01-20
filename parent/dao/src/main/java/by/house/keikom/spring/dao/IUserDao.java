package by.house.keikom.spring.dao;

import java.util.List;

import by.house.keikom.spring.dao.dbmodel.User;

public interface IUserDao {

	Integer create(User user);

	void delete(Integer id);

	void update(User user);

	User getById(Integer id);

	List<User> getAll();
}
