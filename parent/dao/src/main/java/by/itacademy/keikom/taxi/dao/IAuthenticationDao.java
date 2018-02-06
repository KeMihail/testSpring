package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;

public interface IAuthenticationDao extends IHibernateDao<Authentication, Integer> {

	Long count(AuthenticationFilter filter);

	List<Authentication> find(AuthenticationFilter filter);
}
