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

import by.house.keikom.spring.dao.IUserDao;
import by.house.keikom.spring.dao.dbmodel.User;
import by.house.keikom.spring.dao.exeption.SQLExecuteExeption;

@Repository
public class UserDaoImpl extends AbstractDao implements IUserDao {

	private final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public Integer create(User user) {
		try (Connection connect = getConnect();
				PreparedStatement pst = connect.prepareStatement(
						"insert into user (name,last_name,birthday,phone_number,email,created,modified)\r\n"
								+ "values (?,?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS)) {
			LOGGER.debug("Execute SQL: create new User");
			pst.setString(1, user.getName());
			pst.setString(2, user.getLastName());
			pst.setTimestamp(3, user.getBirthday());
			pst.setString(4, user.getPhone_number());
			pst.setString(5, user.getEmail());
			pst.setTimestamp(6, user.getCreated());
			pst.setTimestamp(7, user.getModified());
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			rs.next();
			Integer id = rs.getInt(1);
			return id;
		} catch (SQLException e) {
			throw new SQLExecuteExeption(e);
		}
	}

	@Override
	public void delete(Integer id) {

		try (Connection connect = getConnect();
				PreparedStatement pst = connect.prepareStatement("delete from user where id = ?")) {
			LOGGER.debug("Execute SQL: delete user");
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug("Error from method delete User");
		}

	}

	@Override
	public void update(User user) {

		try (Connection connect = getConnect();
				PreparedStatement pst = connect.prepareStatement(
						"update user set name = ?,last_name = ?,birthday = ?,phone_number = ?,email = ?, deleted = ?,created=?, modified = ? where id = ?")) {
			LOGGER.debug("Execute SQL: update User");

			pst.setString(1, user.getName());
			pst.setString(2, user.getLastName());
			pst.setTimestamp(3, user.getBirthday());
			pst.setString(4, user.getPhone_number());
			pst.setString(5, user.getEmail());
			pst.setBoolean(6, user.getDeleted());
			pst.setTimestamp(7, user.getCreated());
			pst.setTimestamp(8, user.getModified());
			pst.setInt(9, user.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug("Error from method update User");
		}
	}

	@Override
	public User getById(Integer id) {

		try (Connection connect = getConnect();
				PreparedStatement pst = connect.prepareStatement("select * from user where id = ?")) {
			LOGGER.debug("Execute SQL: show one User");

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return parseUser(rs);
			}
		} catch (SQLException e) {
			LOGGER.debug("Error from method getById");
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();

		try (Connection connect = getConnect(); Statement st = connect.createStatement()) {
			LOGGER.debug("Execute SQL: show all Users");

			ResultSet rs = st.executeQuery("select * from user");
			while (rs.next()) {
				list.add(parseUser(rs));
			}
		} catch (SQLException e) {
			LOGGER.debug("Error from method getById");
		}
		return list;
	}

	private User parseUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setBirthday(rs.getTimestamp(4));
		user.setPhone_number(rs.getString(5));
		user.setEmail(rs.getString(6));
		user.setDeleted(rs.getBoolean(7));
		user.setCreated(rs.getTimestamp(8));
		user.setModified(rs.getTimestamp(9));
		return user;
	}
}
