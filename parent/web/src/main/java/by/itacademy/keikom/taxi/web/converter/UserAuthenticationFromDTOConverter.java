package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.dao.enums.UserRole;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.web.dto.UserAuthenticationDTO;

@Component
public class UserAuthenticationFromDTOConverter implements Function<UserAuthenticationDTO, UserAuthentication> {

	@Override
	public UserAuthentication apply(UserAuthenticationDTO dto) {

		UserAuthentication dbModel = new UserAuthentication();

		User user = new User();
		user.setId(dto.getUserId());

		dbModel.setUser(user);
		dbModel.setLogin(dto.getLogin());
		dbModel.setPassword(dto.getPassword());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());
		dbModel.setRole(UserRole.valueOf(dto.getRole()));

		return dbModel;
	}

}
