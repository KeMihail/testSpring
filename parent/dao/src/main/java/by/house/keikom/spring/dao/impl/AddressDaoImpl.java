package by.house.keikom.spring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.house.keikom.spring.dao.IAddressDao;
import by.house.keikom.spring.dao.dbmodel.Address;

public class AddressDaoImpl extends AbstractDao implements IAddressDao {

	private final Logger LOGGER = LoggerFactory.getLogger(AddressDaoImpl.class);

	@Override
	public Integer create(Address address) {

		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub

	}

	@Override
	public Address getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
