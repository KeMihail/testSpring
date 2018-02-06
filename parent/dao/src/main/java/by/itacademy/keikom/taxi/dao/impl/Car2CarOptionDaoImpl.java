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

import by.itacademy.keikom.taxi.dao.ICar2CarOptionDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.dao.filter.Car2CarOptionFilter;

@Repository
public class Car2CarOptionDaoImpl extends AbstractHibernateDaoImpl<Car2CarOption, Integer>
		implements ICar2CarOptionDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(Car2CarOptionDaoImpl.class);

	protected Car2CarOptionDaoImpl() {
		super(Car2CarOption.class);
	}

	@Override
	public Long count(Car2CarOptionFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Car2CarOption> from = cq.from(Car2CarOption.class);
		cq.select(cb.count(from));
		TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<Car2CarOption> find(Car2CarOptionFilter filter) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Car2CarOption> cq = cb.createQuery(Car2CarOption.class);
		Root<Car2CarOption> from = cq.from(Car2CarOption.class);
		cq.select(from);
		// set sort params

		if (filter.getSortProperty() != null) {
			cq.orderBy(new OrderImpl(from.get(filter.getSortProperty()), filter.isSortOrder()));
		}

		TypedQuery<Car2CarOption> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public void create(Car2CarOption obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Car2CarOption obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Car2CarOption obj, Car2CarOption newObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Car2CarOption getById(Car2CarOption obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getOptionsByCar(Integer carId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getCarsByOption(Integer carOptionId) {
		// TODO Auto-generated method stub
		return null;
	}
}
