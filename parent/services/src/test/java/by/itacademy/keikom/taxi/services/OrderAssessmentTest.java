package by.itacademy.keikom.taxi.services;

import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import by.itacademy.keikom.taxi.dao.dbmodel.Brand;
import by.itacademy.keikom.taxi.dao.dbmodel.Car;
import by.itacademy.keikom.taxi.dao.dbmodel.LegalEntity;
import by.itacademy.keikom.taxi.dao.dbmodel.Model;
import by.itacademy.keikom.taxi.dao.dbmodel.Order;
import by.itacademy.keikom.taxi.dao.dbmodel.OrderAssessment;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.dbmodel.User;

public class OrderAssessmentTest extends AbstractServicesTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderAssessmentTest.class);

	@Autowired
	private IOrderAssessmentServices services;

	@Autowired
	private IOrderServices orderServices;

	@Autowired
	private ICarServices carServices;

	@Autowired
	private IUserServices userServices;

	@Autowired
	private IModelServices modelServices;

	@Autowired
	private IBrandServices brandServices;

	@Autowired
	private ILegalEntityServices legalEntityServices;

	@Autowired
	private IRateServices rateServices;

	private List<OrderAssessment> list;

	private Order order;
	private Car car;
	private User user;
	private Model model;
	private Brand brand;
	private LegalEntity legalEntity;
	private Rate rate;
	private User userClient;

	@PostConstruct
	public void prepareTestData() throws ParseException {

		LOGGER.info("prepare data for ModelServicesTest");

		legalEntity = createLegalEntity();
		legalEntityServices.save(legalEntity);

		brand = createBrand();
		brandServices.save(brand);

		model = createModel(brand);
		modelServices.save(model);

		user = createUser();
		// userServices.save(user);

		car = createCar(user, model, legalEntity);
		carServices.save(car);

		rate = createRate();
		rateServices.save(rate);

		userClient = createUserClient();
		// userServices.save(userClient);

		order = createOrder(car, rate, userClient);
		orderServices.save(order);
	}

	@PreDestroy
	public void cleanTestData() {
		legalEntityServices.remove(legalEntity.getId());
		modelServices.remove(model.getId());
		brandServices.remove(brand.getId());
		userServices.remove(user.getId());
		carServices.remove(car.getId());
		rateServices.remove(rate.getId());
		userServices.remove(userClient.getId());
		orderServices.remove(order.getId());
	}

	@Test
	public void testGRUD() {

		OrderAssessment orderAssessment = new OrderAssessment();

		try {
			services.save(orderAssessment);
			Assert.fail();
		} catch (Exception e) {
			LOGGER.error("you cannot save the object entered all of the data");
		}
		orderAssessment = createOrderAssessment(order);
	}

}
