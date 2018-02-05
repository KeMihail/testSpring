package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.web.dto.Car2CarOptionDTO;

@Component
public class Car2CarOptionFromDTOConverter implements Function<Car2CarOptionDTO, Car2CarOption> {

	@Override
	public Car2CarOption apply(Car2CarOptionDTO dto) {

		Car2CarOption dbModel = new Car2CarOption();
		dbModel.setCarId(dto.getCarId());
		dbModel.setCarOptionId(dto.getCarOptionId());

		return dbModel;
	}

}
