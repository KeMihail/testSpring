package by.itacademy.keikom.taxi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import by.itacademy.keikom.taxi.dao.ICarOrderDao;
import by.itacademy.keikom.taxi.dao.dbmodel.CarOrder;
import by.itacademy.keikom.taxi.dao.filter.CarOrderFilter;

@Repository
public class OrderDaoImpl extends AbstractHibernateDaoImpl<CarOrder, Integer> implements ICarOrderDao {

	protected OrderDaoImpl() {
		super(CarOrder.class);
	}

	@Override
	public Long count(CarOrderFilter filter) {

		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<CarOrder> from = cq.from(CarOrder.class);
		cq.select(cb.count(from));
		TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<CarOrder> find(CarOrderFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CarOrder> cq = cb.createQuery(CarOrder.class);
		Root<CarOrder> from = cq.from(CarOrder.class);
		cq.select(from);
		// set sort params

		if (filter.getSortProperty() != null) {
			cq.orderBy(new OrderImpl(from.get(filter.getSortProperty()), filter.isSortOrder()));
		}

		TypedQuery<CarOrder> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}
}
