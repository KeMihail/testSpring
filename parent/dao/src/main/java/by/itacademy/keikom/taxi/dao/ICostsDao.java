package by.itacademy.keikom.taxi.dao;

import java.util.List;

import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.dao.filter.CostsFilter;

public interface ICostsDao extends IHibernateDao<Costs, Integer> {

	Long count(CostsFilter filter);

	List<Costs> find(CostsFilter filter);
}
