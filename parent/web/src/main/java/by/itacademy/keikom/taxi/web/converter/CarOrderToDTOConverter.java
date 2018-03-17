package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.CarOrder;
import by.itacademy.keikom.taxi.web.dto.CarOrderDTO;

@Component
public class CarOrderToDTOConverter implements Function<CarOrder, CarOrderDTO> {

	@Override
	public CarOrderDTO apply(CarOrder dbModel) {

		CarOrderDTO dto = new CarOrderDTO();

		dto.setId(dbModel.getId());
		dto.setArrivalAddress(dbModel.getArrivalAddress());
		dto.setDepartureAddress(dbModel.getDepartureAddress());
		dto.setDistanceOrder(dbModel.getDistanceOrder());
		dto.setDistancePaid(dbModel.getDistancePaid());
		dto.setInactivityMinutes(dbModel.getInactivityMinutes());
		dto.setOrderBegin(dbModel.getOrderBegin());
		dto.setOrderBegin(dbModel.getOrderEnd());
		dto.setTotal(dbModel.getTotal());
		dto.setDeleted(dbModel.getDeleted());

		dto.setRateId(dbModel.getRate().getId());
		dto.setRateName(dbModel.getRate().getName());

		dto.setClientId(dbModel.getClient().getId());
		dto.setClientName(dbModel.getClient().getName());

		dto.setDriverId(dbModel.getDriver().getId());
		dto.setDriverName(dbModel.getDriver().getName());

		return dto;
	}

}
