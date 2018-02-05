package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.web.dto.Car2CarOptionDTO;

@Component
public class Car2CarOptionToDTOConverter implements Function<Car2CarOption, Car2CarOptionDTO> {

	@Override
	public Car2CarOptionDTO apply(Car2CarOption dbModel) {

		Car2CarOptionDTO dto = new Car2CarOptionDTO();
		dto.setCarId(dbModel.getCarId());
		dto.setCarOptionId(dbModel.getCarOptionId());
		return dto;
	}

}
