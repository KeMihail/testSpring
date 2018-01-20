package by.house.keikom.spring.services;

import java.util.List;

import by.house.keikom.spring.dao.dbmodel.Product;

public interface IProductServices {

	Product save(Product product);

	void delete(Integer id);

	Product getById(Integer id);

	List<Product> getAll();
}
