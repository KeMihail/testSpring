package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Car;
import by.itacademy.keikom.taxi.dao.dbmodel.ServiceItem;
import by.itacademy.keikom.taxi.dao.enums.EServiceItem;
import by.itacademy.keikom.taxi.web.dto.ServiceItemDTO;

@Component
public class ServiceItemFromDTOConverter implements Function<ServiceItemDTO, ServiceItem> {

	@Override
	public ServiceItem apply(ServiceItemDTO dto) {

		ServiceItem dbModel = new ServiceItem();

		dbModel.setId(dto.getId());
		
		Car car = new Car();
		car.setId(dto.getCarId());
		dbModel.setCar(car);
		
		dbModel.setItem(EServiceItem.valueOf(dto.getItem()));
		dbModel.setSumma(dto.getSumma());

		return dbModel;
	}

}
