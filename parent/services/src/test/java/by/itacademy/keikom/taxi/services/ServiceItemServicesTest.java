package by.itacademy.keikom.taxi.services;

import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.itacademy.keikom.taxi.dao.dbmodel.Brand;
import by.itacademy.keikom.taxi.dao.dbmodel.Car;
import by.itacademy.keikom.taxi.dao.dbmodel.LegalEntity;
import by.itacademy.keikom.taxi.dao.dbmodel.Model;
import by.itacademy.keikom.taxi.dao.dbmodel.ServiceItem;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.services.impl.ServiceItemServicesImpl;

public class ServiceItemServicesTest extends AbstractServicesTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceItemServicesTest.class);

	@Autowired
	private IServiceItem services;

	private List<ServiceItem> list;

	private Brand brand;
	@Autowired
	private IBrandServices brandServices;

	private Model model;
	@Autowired
	private IModelServices modelServices;

	private LegalEntity legalEntity;
	@Autowired
	private ILegalEntityServices legalEntityServices;

	private Car car;
	@Autowired
	private ICarServices carServices;

	private User userDriver;
	@Autowired
	private IUserServices userServisec;

	@PostConstruct
	public void prepareTestData() throws ParseException {

		brand = createBrand();
		brandServices.save(brand);

		model = createModel(brand);
		modelServices.save(model);

		legalEntity = createLegalEntity();
		legalEntityServices.save(legalEntity);

		userDriver = createUser();
		userServisec.save(userDriver);

		car = createCar(userDriver, model, legalEntity);
		carServices.save(car);
	}

	@PreDestroy
	public void cleanTestData() {

		brandServices.remove(brand.getId());
		modelServices.remove(model.getId());
		legalEntityServices.remove(legalEntity.getId());
		userServisec.remove(userDriver.getId());
		carServices.remove(car.getId());
	}

	@Test
	public void testGRUD() {

		ServiceItem serviceItem = null;
		try {
			services.save(serviceItem);
			Assert.fail();
		} catch (Exception e) {
			LOGGER.error("you cannot save the object entered all of the data");
		}

		serviceItem = createServiceItem(car);
		services.save(serviceItem);
		Assert.assertNotNull(services.get(serviceItem.getCar().getId()));

		ServiceItem serviceItem1 = services.get(serviceItem.getCar().getId());
		Assert.assertEquals(serviceItem1.getCar(), serviceItem.getCar());
		Assert.assertEquals(serviceItem1.getItem(), serviceItem.getItem());
		Assert.assertEquals(serviceItem1.getSumma(), serviceItem.getSumma());

		serviceItem.setSumma(300.0);
		services.save(serviceItem1);
		Assert.assertNotNull(serviceItem1);

		ServiceItem serviceItem2 = services.get(serviceItem.getCar().getId());
		Assert.assertEquals(serviceItem2.getCar(), serviceItem.getCar());
		Assert.assertEquals(serviceItem1.getItem(), serviceItem.getItem());
		Assert.assertEquals(serviceItem1.getSumma(), serviceItem.getSumma());
		list = services.getAll();
		Assert.assertNotNull(list);

		services.remove(serviceItem1.getCar().getId());
		Assert.assertNull(services.get(serviceItem1.getCar().getId()));
	}
}
