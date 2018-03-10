package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Car;
import by.itacademy.keikom.taxi.web.dto.CarDTO;

@Component
public class CarToDTOConverter implements Function<Car, CarDTO> {

	@Override
	public CarDTO apply(Car dbModel) {

		CarDTO dto = new CarDTO();

		dto.setId(dbModel.getId());
		
		dto.setUserName(dbModel.getUser().getName());
		
		dto.setReleaseYear(dbModel.getReleaseYear());
		dto.setModel(dbModel.getModel());
		dto.setLegalEntity(dbModel.getLegalEntity());
		dto.setStatus(dbModel.getStatus().toString());
		dto.setCreated(dbModel.getCreated());
		dto.setModified(dbModel.getModified());

		return dto;
	}

}
