package by.house.keikom.spring.dao;

import java.util.List;

import by.house.keikom.spring.dao.dbmodel.Product;

public interface IProductDao {

	Integer create(Product product);

	void delete(Integer id);

	void update(Product product);

	Product getById(Integer id);

	List<Product> getAll();
}
