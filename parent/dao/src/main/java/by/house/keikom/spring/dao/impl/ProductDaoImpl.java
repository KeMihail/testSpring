package by.house.keikom.spring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.house.keikom.spring.dao.IProductDao;
import by.house.keikom.spring.dao.dbmodel.Product;
import by.house.keikom.spring.dao.exeption.SQLExecuteExeption;

@Repository
public class ProductDaoImpl extends AbstractDao implements IProductDao {

	private Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Override
	public Integer create(Product product) {

		try (Connection connect = getConnect();
				PreparedStatement pst = connect.prepareStatement(
						"insert into product (name,manufacturer,price,created,modified) values (?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS)) {
			LOGGER.debug("ExecuteSQL: create new product");

			pst.setString(1, product.getName());
			pst.setString(2, product.getManufacturer());
			pst.setDouble(3, product.getPrice());
			pst.setTimestamp(4, product.getCreated());
			pst.setTimestamp(5, product.getModified());
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			rs.next();
			Integer id = rs.getInt(1);
			return id;
		} catch (Exception e) {
			throw new SQLExecuteExeption(e);
		}
	}

	@Override
	public void delete(Integer id) {

		try (Connection connect = getConnect();
				PreparedStatement pst = connect.prepareStatement("delete from product where id = ?")) {
			LOGGER.debug("Execute SQL: delete one product");

			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("Error from method delete one product");
		}
	}

	@Override
	public void update(Product product) {

		try (Connection connect = getConnect();
				PreparedStatement pst = connect.prepareStatement(
						"update product set name = ?,manufacturer = ?,price = ?,deleted = ?, modified = ? where id = ?")) {
			LOGGER.debug("Execute SQL: update product");

			pst.setString(1, product.getName());
			pst.setString(2, product.getManufacturer());
			pst.setDouble(3, product.getPrice());
			pst.setBoolean(4, product.getDeleted());
			pst.setTimestamp(5, product.getModified());
			pst.setInt(6, product.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("Error from method update");
		}
	}

	@Override
	public Product getById(Integer id) {

		try (Connection connect = getConnect();
				PreparedStatement pst = connect.prepareStatement("select * from product where id = ?")) {
			LOGGER.debug("Execute SQL: show one product");

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Product product = new Product();

				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setManufacturer(rs.getString(3));
				product.setPrice(rs.getDouble(4));
				product.setDeleted(rs.getBoolean(5));
				product.setCreated(rs.getTimestamp(6));
				product.setModified(rs.getTimestamp(7));
				return product;
			}
		} catch (SQLException e) {
			LOGGER.error("Error from method getById");
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		Product product = new Product();
		List<Product> list = new ArrayList<Product>();
		try (Connection connect = getConnect(); Statement st = connect.createStatement()) {
			LOGGER.debug("Execute SQL: show all product");
			ResultSet rs = st.executeQuery("select * from product");
			while (rs.next()) {

				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setManufacturer(rs.getString(3));
				product.setPrice(rs.getDouble(4));
				product.setDeleted(rs.getBoolean(5));
				product.setCreated(rs.getTimestamp(6));
				product.setModified(rs.getTimestamp(7));
				list.add(product);
				return list;
			}
		} catch (SQLException e) {
			LOGGER.error("Error from method getAll");
		}
		return list;
	}
}
