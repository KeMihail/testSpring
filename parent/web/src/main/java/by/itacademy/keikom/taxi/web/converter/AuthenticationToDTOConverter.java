package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser;
import by.itacademy.keikom.taxi.web.dto.AuthenticationDTO;

@Component
public class AuthenticationToDTOConverter implements Function<AuthenticationUser, AuthenticationDTO> {

	@Override
	public AuthenticationDTO apply(AuthenticationUser dbModel) {

		AuthenticationDTO dto = new AuthenticationDTO();

		dto.setUserId(dbModel.getUser().getId());
		dto.setLogin(dbModel.getLogin());
		dto.setPassword(dbModel.getPassword());
		dto.setCreated(dbModel.getCreated());
		dto.setModified(dbModel.getModified());

		return dto;
	}

}
