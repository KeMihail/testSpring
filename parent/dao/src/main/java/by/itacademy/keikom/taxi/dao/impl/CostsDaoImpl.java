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

import by.itacademy.keikom.taxi.dao.ICostsDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.dao.filter.CostsFilter;

@Repository
public class CostsDaoImpl extends AbstractHibernateDaoImpl<Costs, Integer> implements ICostsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CostsDaoImpl.class);

	protected CostsDaoImpl() {
		super(Costs.class);
	}

	@Override
	public Long count(CostsFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Costs> from = cq.from(Costs.class);
		cq.select(cb.count(from));
		TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<Costs> find(CostsFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Costs> cq = cb.createQuery(Costs.class);
		Root<Costs> from = cq.from(Costs.class);
		cq.select(from);
		// set sort params

		if (filter.getSortProperty() != null) {
			cq.orderBy(new OrderImpl(from.get(filter.getSortProperty()), filter.isSortOrder()));
		}

		TypedQuery<Costs> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}
}
