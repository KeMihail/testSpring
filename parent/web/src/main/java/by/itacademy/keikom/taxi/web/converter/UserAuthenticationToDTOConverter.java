package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.web.dto.UserAuthenticationDTO;

@Component
public class UserAuthenticationToDTOConverter implements Function<UserAuthentication, UserAuthenticationDTO> {

	@Override
	public UserAuthenticationDTO apply(UserAuthentication dbModel) {

		UserAuthenticationDTO dto = new UserAuthenticationDTO();

		dto.setUserId(dbModel.getUser().getId());
		dto.setLogin(dbModel.getLogin());
		dto.setPassword(dbModel.getPassword());
		dto.setCreated(dbModel.getCreated());
		dto.setModified(dbModel.getModified());
		dto.setRole(dbModel.getRole().toString());

		return dto;
	}

}
