package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.enums.CarStatus;

import by.itacademy.keikom.taxi.dao.dbmodel.Car;
import by.itacademy.keikom.taxi.web.dto.CarDTO;

@Component
public class CarFromDTOConverter implements Function<CarDTO, Car> {

	@Override
	public Car apply(CarDTO dto) {

		Car dbModel = new Car();

		dbModel.setId(dto.getId());
		// посмотреть пример с cover  и cover deteilis 
		
		//dbModel.setUser(dto.getUser());
		dbModel.setReleaseYear(dto.getReleaseYear());
		dbModel.setModel(dto.getModel());
		dbModel.setLegalEntity(dto.getLegalEntity());
		dbModel.setStatus(CarStatus.valueOf(dto.getStatus()));
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		return dbModel;
	}

}
