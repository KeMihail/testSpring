package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.web.dto.AuthenticationDTO;

@Component
public class AuthenticationFromDTOConverter implements Function<AuthenticationDTO, AuthenticationUser> {

	@Override
	public AuthenticationUser apply(AuthenticationDTO dto) {

		AuthenticationUser dbModel = new AuthenticationUser();

		User user = new User();
		user.setId(dto.getUserId());

		dbModel.setUser(user);
		dbModel.setLogin(dto.getLogin());
		dbModel.setPassword(dto.getPassword());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		return dbModel;
	}

}
