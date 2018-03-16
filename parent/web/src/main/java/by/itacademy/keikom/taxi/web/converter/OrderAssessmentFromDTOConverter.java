package by.itacademy.keikom.taxi.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.Order;
import by.itacademy.keikom.taxi.dao.dbmodel.OrderAssessment;
import by.itacademy.keikom.taxi.web.dto.OrderAssessmentDTO;

@Component
public class OrderAssessmentFromDTOConverter implements Function<OrderAssessmentDTO, OrderAssessment> {

	@Override
	public OrderAssessment apply(OrderAssessmentDTO dto) {

		OrderAssessment dbModel = new OrderAssessment();

		dbModel.setId(dto.getId());
		dbModel.setAssessment(dto.getAssessment());
		dbModel.setComment(dto.getComment());
		dbModel.setCreated(dto.getCreated());
		dbModel.setModified(dto.getModified());

		Order order = new Order();
		order.setId(dto.getOrderId());
		dbModel.setOrder(order);

		return dbModel;
	}

}
