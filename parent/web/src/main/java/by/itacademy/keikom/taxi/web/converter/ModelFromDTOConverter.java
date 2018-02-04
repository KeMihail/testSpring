package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.enums.BodyType;
import by.itacademy.keikom.taxi.dao.enums.CarKit;
import by.itacademy.keikom.taxi.dao.enums.EngineType;
import by.itacademy.keikom.taxi.dao.dbmodel.Model;
import by.itacademy.keikom.taxi.web.dto.ModelDTO;

@Component
public class ModelFromDTOConverter implements Function<ModelDTO, Model> {

	@Override
	public Model apply(ModelDTO dto) {

		Model dbModel = new Model();

		dbModel.setId(dto.getId());
		dbModel.setName(dto.getName());
		dbModel.setCarCit(CarKit.valueOf(dto.getCarCit()));
		dbModel.setEngineType(EngineType.valueOf(dto.getEngineType()));
		dbModel.setBodyType(BodyType.valueOf(dto.getBodyType()));
		dbModel.setBrandId(dto.getBrandId());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		return dbModel;
	}

}
