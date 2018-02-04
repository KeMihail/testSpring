package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IModelDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Model;
import by.itacademy.keikom.taxi.services.IModelServices;

@Service
public class ModelServicesImpl implements IModelServices {

	@Autowired
	private IModelDao dao;

	@Override
	public Model save(Model model) {

		model.setModified(new Timestamp(new Date().getTime()));

		if (model.getId() != null) {
			dao.update(model);
		} else {
			model.setCreated(new Timestamp(new Date().getTime()));
			dao.insert(model);
		}
		return model;
	}

	@Override
	public void delete(Integer id) {
		dao.remove(id);
	}

	@Override
	public Model getById(Integer id) {
		return dao.get(id);
	}

	@Override
	public List<Model> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Model> getAll(String sortColumn, boolean sortAscending, int limit, int offset) {
		final List<Model> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<Model>() {
			@Override
			public int compare(Model o1, Model o2) {
				if (sortAscending) {
					final Model temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("id".equals(sortColumn)) {
					return o1.getId().compareTo(o2.getId());
				} else if ("name".equals(sortColumn)) {
					return o1.getName().compareTo(o2.getName());
				} else if ("name".equals(sortColumn)) {
					return o1.getName().compareTo(o2.getName());
				} else if ("carCit".equals(sortColumn)) {
					return o1.getCarCit().compareTo(o2.getCarCit());
				} else if ("engineType".equals(sortColumn)) {
					return o1.getEngineType().compareTo(o2.getEngineType());
				} else if ("BodyType".equals(sortColumn)) {
					return o1.getBodyType().compareTo(o2.getBodyType());
				} else if ("brandId".equals(sortColumn)) {
					return o1.getBrandId().compareTo(o2.getBrandId());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});
		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}

	@Override
	public Integer getCount() {
		return getAll().size();
	}
}
