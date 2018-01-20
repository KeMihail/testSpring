package by.house.keikom.spring.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.house.keikom.spring.dao.IProductDao;
import by.house.keikom.spring.dao.dbmodel.Product;
import by.house.keikom.spring.services.IProductServices;

@Service
public class ProductServicesImpl implements IProductServices {

	@Autowired
	private IProductDao dao;

	@Override
	public Product save(Product product) {

		product.setModified(new Timestamp(new Date().getTime()));

		if (product.getId() != null) {
			dao.update(product);
		} else {
			product.setCreated(new Timestamp(new Date().getTime()));
			Integer id = dao.create(product);
			product.setId(id);
		}
		return product;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Product getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Product> getAll() {
		return dao.getAll();
	}
}
