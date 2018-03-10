package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;

public interface IAuthenticationUserDao extends IHibernateDao<AuthenticationUser, Integer> {

	Long count(AuthenticationFilter filter);

	List<AuthenticationUser> find(AuthenticationFilter filter);

	AuthenticationUser loadByLogin(String login);
}
