package by.itacademy.keikom.taxi.web.converter;

import org.springframework.stereotype.Controller;

import com.google.common.base.Function;

import by.itacademy.keikom.taxi.dao.dbmodel.LegalEntity;
import by.itacademy.keikom.taxi.web.dto.LegalEntityDTO;

@Controller
public class LegalEntityFromDTOConverter implements Function<LegalEntityDTO, LegalEntity> {

	@Override
	public LegalEntity apply(LegalEntityDTO dto) {

		LegalEntity dbModel = new LegalEntity();

		dbModel.setId(dto.getId());
		dbModel.setName(dto.getName());
		dbModel.setAddress(dto.getAddress());
		dbModel.setEmail(dto.getEmail());
		dbModel.setPhoneNumber(dto.getPhoneNumber());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		return dbModel;
	}

}
