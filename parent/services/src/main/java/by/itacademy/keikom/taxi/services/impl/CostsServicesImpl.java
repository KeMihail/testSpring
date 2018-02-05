package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.ICostsDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.services.ICostsServices;

@Service
public class CostsServicesImpl implements ICostsServices {

	@Autowired
	private ICostsDao dao;

	@Override
	public Costs save(Costs costs) {

		costs.setModified(new Timestamp(new Date().getTime()));

		if (costs.getCreated() != null) {
			dao.update(costs);
		} else {
			costs.setCreated(new Timestamp(new Date().getTime()));
			dao.create(costs);
		}
		return costs;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Costs getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Costs> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<Costs> getAll(final String sortColumn, final boolean sortAscending, final int limit, final int offset) {
		final List<Costs> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<Costs>() {
			@Override
			public int compare(Costs o1, Costs o2) {
				if (sortAscending) {
					final Costs temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("carId".equals(sortColumn)) {
					return o1.getCarId().compareTo(o2.getCarId());
				} else if ("taxes".equals(sortColumn)) {
					return o1.getTaxes().compareTo(o2.getTaxes());
				} else if ("technicalInspection".equals(sortColumn)) {
					return o1.getTechnicalInspection().compareTo(o2.getTechnicalInspection());
				} else if ("insurance".equals(sortColumn)) {
					return o1.getInsurance().compareTo(o2.getInsurance());
				} else if ("carService".equals(sortColumn)) {
					return o1.getCarService().compareTo(o2.getCarService());
				} else if ("pretripInspection".equals(sortColumn)) {
					return o1.getPretripInspection().compareTo(o2.getPretripInspection());
				} else if ("salaryDriver".equals(sortColumn)) {
					return o1.getSalaryDriver().compareTo(o2.getSalaryDriver());
				} else if ("fuelConsumption".equals(sortColumn)) {
					return o1.getFuelConsumption().compareTo(o2.getFuelConsumption());
				} else if ("other".equals(sortColumn)) {
					return o1.getOther().compareTo(o2.getOther());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
