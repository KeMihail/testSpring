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

import by.itacademy.keikom.taxi.dao.IAuthenticationDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.dao.dbmodel.Authentication_;
import by.itacademy.keikom.taxi.dao.dbmodel.User_;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;

@Repository
public class AuthenticationDaoImpl extends AbstractHibernateDaoImpl<Authentication, Integer>
		implements IAuthenticationDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationDaoImpl.class);

	protected AuthenticationDaoImpl() {
		super(Authentication.class);
	}

	@Override
	public Long count(AuthenticationFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Authentication> from = cq.from(Authentication.class);
		cq.select(cb.count(from));
		TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<Authentication> find(final AuthenticationFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Authentication> cq = cb.createQuery(Authentication.class);
		final Root<Authentication> from = cq.from(Authentication.class);
		cq.select(from);

		from.fetch(Authentication_.user, JoinType.LEFT); // comment this line to see
		// how
		// OpenSessionInViewFilter
		// fetches LAZY items

		// set sort params
		final SingularAttribute sortProperty = filter.getSortProperty();
		if (sortProperty != null) {
			Path expression;
			if (User_.address.equals(sortProperty) || User_.name.equals(sortProperty)
					|| User_.lastName.equals(sortProperty) || User_.birthday.equals(sortProperty)
					|| User_.email.equals(sortProperty) || User_.cars.equals(sortProperty)
					|| User_.orders.equals(sortProperty) || User_.phoneNumber.equals(sortProperty)) {
				expression = from.get(Authentication_.user).get(sortProperty);
			} else {
				expression = from.get(sortProperty);
			}
			cq.orderBy(new OrderImpl(expression, filter.isSortOrder()));
		}

		final TypedQuery<Authentication> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}
}
