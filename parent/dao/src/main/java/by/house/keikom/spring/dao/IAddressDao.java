package by.house.keikom.spring.dao;

import java.util.List;

import by.house.keikom.spring.dao.dbmodel.Address;

public interface IAddressDao {

	Integer create(Address address);

	void delete(Integer id);

	void update(Address address);

	Address getById(Integer id);

	List<Address> getAll();
}
