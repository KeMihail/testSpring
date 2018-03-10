package by.itacademy.keikom.taxi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.jpa.criteria.OrderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.itacademy.keikom.taxi.dao.IAuthenticationUserDao;
import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser;
import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser_;
import by.itacademy.keikom.taxi.dao.dbmodel.Model;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;

@Repository
public class AuthenticationUserDaoImpl extends AbstractHibernateDaoImpl<AuthenticationUser, Integer>
		implements IAuthenticationUserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationUserDaoImpl.class);

	protected AuthenticationUserDaoImpl() {
		super(AuthenticationUser.class);
	}

	@Override
	public Long count(AuthenticationFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<AuthenticationUser> from = cq.from(AuthenticationUser.class);
		cq.select(cb.count(from));
		TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<AuthenticationUser> find(final AuthenticationFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<AuthenticationUser> cq = cb.createQuery(AuthenticationUser.class);
		final Root<AuthenticationUser> from = cq.from(AuthenticationUser.class);
		cq.select(from);

		from.fetch(AuthenticationUser_.user, JoinType.LEFT);

		if (filter.getSortProperty() != null) {
			cq.orderBy(new OrderImpl(from.get(filter.getSortProperty()), filter.isSortOrder()));
		}

		TypedQuery<AuthenticationUser> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public AuthenticationUser loadByLogin(String login) {

		EntityManager em = getEntityManager();
		AuthenticationUser authenticationUser = em
				.createQuery("select a from AuthenticationUser a where a.login = :login", AuthenticationUser.class)
				.setParameter("login", login).getSingleResult();

		return authenticationUser;
	}
}

/*
 * final SingularAttribute sortProperty = filter.getSortProperty();
 * 
 * if (sortProperty != null) { Path expression; if
 * (User_.address.equals(sortProperty) || User_.name.equals(sortProperty) ||
 * User_.lastName.equals(sortProperty) || User_.birthday.equals(sortProperty) ||
 * User_.email.equals(sortProperty) || User_.cars.equals(sortProperty) ||
 * User_.orders.equals(sortProperty) || User_.phoneNumber.equals(sortProperty))
 * { expression = from.get(Authentication_.user).get(sortProperty); } else {
 * expression = from.get(sortProperty); } cq.orderBy(new OrderImpl(expression,
 * filter.isSortOrder())); }
 */