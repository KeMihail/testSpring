package by.itacademy.keikom.taxi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.itacademy.keikom.taxi.dao.IAuthenticationDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
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
	public List<Authentication> find(AuthenticationFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Authentication> cq = cb.createQuery(Authentication.class);
		Root<Authentication> from = cq.from(Authentication.class);
		cq.select(from);
		// set sort params

		if (filter.getSortProperty() != null) {
			cq.orderBy(new OrderImpl(from.get(filter.getSortProperty()), filter.isSortOrder()));
		}

		TypedQuery<Authentication> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

}
