package by.itacademy.keikom.taxi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IServiceItemDao;
import by.itacademy.keikom.taxi.dao.dbmodel.ServiceItem;
import by.itacademy.keikom.taxi.dao.filter.ServiceItemFilter;
import by.itacademy.keikom.taxi.services.IServiceItem;

@Service
public class ServiceItemServicesImpl implements IServiceItem {

	@Autowired
	private IServiceItemDao dao;

	@Override
	public void remove(final Integer id) {
		dao.remove(id);

	}

	@Override
	public ServiceItem save(final ServiceItem serviceItem) {
		if (serviceItem.getCar() == null) {
			dao.insert(serviceItem);
		} else {
			dao.update(serviceItem);
		}
		return serviceItem;
	}

	@Override
	public List<ServiceItem> getAll() {
		return dao.getAll();
	}

	@Override
	public ServiceItem get(final Integer id) {
		return dao.get(id);
	}

	@Override
	public Long getCount(ServiceItemFilter filter) {
		return dao.count(filter);
	}

	@Override
	public List<ServiceItem> getAll(ServiceItemFilter filter) {
		return dao.find(filter);
	}
}
