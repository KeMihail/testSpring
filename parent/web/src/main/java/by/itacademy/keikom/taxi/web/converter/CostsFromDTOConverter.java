package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.web.dto.CostsDTO;

@Component
public class CostsFromDTOConverter implements Function<CostsDTO, Costs> {

	@Override
	public Costs apply(CostsDTO dto) {
		Costs dbModel = new Costs();

		dbModel.setCarId(dto.getCarId());
		dbModel.setTaxes(dto.getTaxes());
		dbModel.setTechnicalInspection(dto.getTechnicalInspection());
		dbModel.setInsurance(dto.getInsurance());
		dbModel.setCarService(dto.getCarService());
		dbModel.setPretripInspection(dto.getPretripInspection());
		dbModel.setSalaryDriver(dto.getSalaryDriver());
		dbModel.setFuelConsumption(dto.getFuelConsumption());
		dbModel.setOther(dto.getOther());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		return dbModel;
	}

}
