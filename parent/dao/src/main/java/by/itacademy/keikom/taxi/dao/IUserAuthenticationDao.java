package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;

public interface IUserAuthenticationDao extends IHibernateDao<UserAuthentication, Integer> {

	Long count(AuthenticationFilter filter);

	List<UserAuthentication> find(AuthenticationFilter filter);

	UserAuthentication loadByLogin(String login);
}
