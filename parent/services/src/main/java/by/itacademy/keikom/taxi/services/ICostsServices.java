package by.itacademy.keikom.taxi.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.dao.filter.CostsFilter;

public interface ICostsServices {

	@Transactional
	void remove(Integer id);

	@Transactional
	Costs save(Costs costs);

	List<Costs> getAll();

	Costs get(Integer id);

	Long getCount(CostsFilter filter);

	List<Costs> getAll(CostsFilter filter);
}
