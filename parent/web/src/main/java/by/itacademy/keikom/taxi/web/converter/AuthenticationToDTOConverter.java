package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.web.dto.AuthenticationDTO;

@Component
public class AuthenticationToDTOConverter implements Function<Authentication, AuthenticationDTO> {

	@Override
	public AuthenticationDTO apply(Authentication dbModel) {

		AuthenticationDTO dto = new AuthenticationDTO();

		dto.setUserId(dbModel.getUserId());
		dto.setLogin(dbModel.getLogin());
		dto.setPassword(dbModel.getPassword());
		dto.setCreated(dbModel.getCreated());
		dto.setModified(dbModel.getModified());

		return dto;
	}

}