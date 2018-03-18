package by.itacademy.keikom.taxi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import by.itacademy.keikom.taxi.dao.IServiceItemDao;
import by.itacademy.keikom.taxi.dao.dbmodel.ServiceItem;
import by.itacademy.keikom.taxi.dao.filter.ServiceItemFilter;

@Repository
public class ServiceItemDaoImpl extends AbstractHibernateDaoImpl<ServiceItem, Integer> implements IServiceItemDao {

	protected ServiceItemDaoImpl() {
		super(ServiceItem.class);
	}

	@Override
	public Long count(ServiceItemFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<ServiceItem> from = cq.from(ServiceItem.class);
		cq.select(cb.count(from));
		TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<ServiceItem> find(ServiceItemFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ServiceItem> cq = cb.createQuery(ServiceItem.class);
		Root<ServiceItem> from = cq.from(ServiceItem.class);
		cq.select(from);

		// from.fetch(ServiceItem_.car, JoinType.LEFT);

		if (filter.getSortProperty() != null) {
			cq.orderBy(new OrderImpl(from.get(filter.getSortProperty()), filter.isSortOrder()));
		}

		TypedQuery<ServiceItem> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}
}
