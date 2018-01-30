package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.enums.UserRole;
import by.itacademy.keikom.taxi.web.dto.UserDTO;

@Component
public class UserFromDTOConverter implements Function<UserDTO, User> {

	@Override
	public User apply(UserDTO dto) {

		User dbModel = new User();

		dbModel.setId(dto.getId());
		dbModel.setRole(UserRole.valueOf(dto.getRole()));
		dbModel.setName(dto.getName());
		dbModel.setLastName(dto.getLastName());
		dbModel.setBirthday(dto.getBirthday());
		dbModel.setAddress(dto.getAddress());
		dbModel.setPhoneNumber(dto.getPhoneNumber());
		dbModel.setEmail(dto.getEmail());
		dbModel.setDeleted(dto.getDeleted());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		return dbModel;

	}

}
