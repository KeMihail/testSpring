package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.web.dto.AuthenticationDTO;

@Component
public class AuthenticationFromDTOConverter implements Function<AuthenticationDTO, Authentication> {

	@Override
	public Authentication apply(AuthenticationDTO dto) {

		Authentication dbModel = new Authentication();

		dbModel.setUserId(dto.getUserId());
		dbModel.setLogin(dto.getLogin());
		dbModel.setPassword(dto.getPassword());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		return dbModel;
	}

}
