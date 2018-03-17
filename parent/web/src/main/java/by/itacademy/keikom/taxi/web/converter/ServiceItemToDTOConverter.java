package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.ServiceItem;
import by.itacademy.keikom.taxi.web.dto.ServiceItemDTO;

@Component
public class ServiceItemToDTOConverter implements Function<ServiceItem, ServiceItemDTO> {

	@Override
	public ServiceItemDTO apply(ServiceItem dbModel) {

		ServiceItemDTO dto = new ServiceItemDTO();

		dto.setId(dbModel.getId());
		dto.setCarId(dbModel.getCar().getId());
		dto.setItem(dbModel.getItem().toString());
		dto.setSumma(dbModel.getSumma());
		dto.setCarName(dbModel.getCar().getModel().getName());

		return dto;
	}
}
