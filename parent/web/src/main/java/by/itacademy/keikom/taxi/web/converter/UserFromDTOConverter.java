package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.dao.enums.UserRole;
import by.itacademy.keikom.taxi.web.dto.UserDTO;

@Component
public class UserFromDTOConverter implements Function<UserDTO, User> {

	@Override
	public User apply(UserDTO dto) {

		User dbModel = new User();

		dbModel.setId(dto.getId());
		dbModel.setName(dto.getName());
		dbModel.setLastName(dto.getLastName());
		dbModel.setBirthday(dto.getBirthday());
		dbModel.setAddress(dto.getAddress());
		dbModel.setPhoneNumber(dto.getPhoneNumber());
		dbModel.setEmail(dto.getEmail());
		dbModel.setDeleted(dto.getDeleted());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		UserAuthentication authentication = new UserAuthentication();
		authentication.setLogin(dto.getLogin());
		authentication.setPassword(dto.getPasword());
		authentication.setRole(UserRole.valueOf(dto.getRole()));

		dbModel.setAuthentication(authentication);

		return dbModel;

	}

}
