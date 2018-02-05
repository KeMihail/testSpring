package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.web.dto.CostsDTO;

@Component
public class CostsToDTOConverter implements Function<Costs, CostsDTO> {

	@Override
	public CostsDTO apply(Costs dbModel) {

		CostsDTO dto = new CostsDTO();

		dto.setCarId(dbModel.getCarId());
		dto.setTaxes(dbModel.getTaxes());
		dto.setTechnicalInspection(dbModel.getTechnicalInspection());
		dto.setInsurance(dbModel.getInsurance());
		dto.setCarService(dbModel.getCarService());
		dto.setPretripInspection(dbModel.getPretripInspection());
		dto.setSalaryDriver(dbModel.getSalaryDriver());
		dto.setFuelConsumption(dbModel.getFuelConsumption());
		dto.setOther(dbModel.getOther());
		dto.setCreated(dbModel.getCreated());
		dto.setModified(dbModel.getModified());

		return dto;
	}

}
