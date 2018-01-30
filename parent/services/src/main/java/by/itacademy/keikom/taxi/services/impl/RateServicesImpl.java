package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IRateDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.services.IRateServices;

@Service
public class RateServicesImpl implements IRateServices {

	@Autowired
	private IRateDao dao;;

	@Override
	public Rate save(Rate rate) {

		rate.setModified(new Timestamp(new Date().getTime()));

		if (rate.getId() != null) {
			dao.update(rate);
		} else {
			rate.setCreated(new Timestamp(new Date().getTime()));
			Integer id = dao.create(rate);
			rate.setId(id);
		}
		return rate;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Rate getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Rate> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<Rate> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset) {
		final List<Rate> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<Rate>() {
			@Override
			public int compare(Rate o1, Rate o2) {
				if (sortAscending) {
					final Rate temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("id".equals(sortColumn)) {
					return o1.getId().compareTo(o2.getId());
				} else if ("name".equals(sortColumn)) {
					return o1.getName().compareTo(o2.getName());
				} else if ("priceLanding".equals(sortColumn)) {
					return o1.getPriceLanding().compareTo(o2.getPriceLanding());
				} else if ("priceKilometr".equals(sortColumn)) {
					return o1.getPriceKilometr().compareTo(o2.getPriceKilometr());
				} else if ("priceMinuteWait".equals(sortColumn)) {
					return o1.getPriceMinuteWait().compareTo(o2.getPriceMinuteWait());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
