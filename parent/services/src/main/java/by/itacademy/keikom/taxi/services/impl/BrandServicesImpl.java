package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IBrandDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Brand;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.impl.BrandDaoImpl;
import by.itacademy.keikom.taxi.services.IBrandServices;

@Service
public class BrandServicesImpl implements IBrandServices {

	@Autowired
	private IBrandDao dao;

	@Override
	public Brand save(Brand brand) {

		brand.setModified(new Timestamp(new Date().getTime()));

		if (brand.getId() != null) {
			dao.update(brand);
		} else {
			brand.setCreated(new Timestamp(new Date().getTime()));
			Integer id = dao.create(brand);
			brand.setId(id);
		}
		return brand;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Brand getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Brand> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<Brand> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset) {
		final List<Brand> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<Brand>() {
			@Override
			public int compare(Brand o1, Brand o2) {
				if (sortAscending) {
					final Brand temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("id".equals(sortColumn)) {
					return o1.getId().compareTo(o2.getId());
				} else if ("name".equals(sortColumn)) {
					return o1.getName().compareTo(o2.getName());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
