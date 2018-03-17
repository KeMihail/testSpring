package by.itacademy.keikom.taxi.services;

import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

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
import by.itacademy.keikom.taxi.dao.dbmodel.User;

public class CarServicesTest extends AbstractServicesTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarServicesTest.class);

	@Autowired
	private ICarServices services;
	private List<Car> list;

	private Model model = new Model();
	@Autowired
	private IModelServices modelServices;

	private LegalEntity legalEntity;
	@Autowired
	private ILegalEntityServices legalEntityServices;

	private User user;
	@Autowired
	private IUserServices userServisec;

	private Brand brand;
	@Autowired
	private IBrandServices brandServices;

	@PostConstruct
	public void prepareTestData() throws ParseException {

		brand = createBrand();
		brandServices.save(brand);

		model = createModel(brand);
		modelServices.save(model);

		legalEntity = createLegalEntity();
		legalEntityServices.save(legalEntity);

		user = createUser();
		userServisec.save(user);
	}

	@PreDestroy
	public void cleanTestData() {

		brandServices.remove(brand.getId());
		modelServices.remove(model.getId());
		legalEntityServices.remove(legalEntity.getId());
		userServisec.remove(user.getId());

	}

	@Test
	public void testGRUD() {

		Car car = null;

		try {
			services.save(car);
			Assert.fail();
		} catch (Exception e) {
			LOGGER.error("you cannot save the object entered all of the data");
		}

		car = createCar(user, model, legalEntity);
		services.save(car);
		Assert.assertNotNull(services.get(car.getId()));

		Car car1 = services.get(car.getId());
		Assert.assertEquals(car1.getId(), car.getId());
		Assert.assertEquals(car1.getReleaseYear(), car.getReleaseYear());
		Assert.assertEquals(car1.getModel(), car.getModel());
		Assert.assertEquals(car1.getLegalEntity(), car.getLegalEntity());
		Assert.assertEquals(car1.getStatus(), car.getStatus());

		car.setReleaseYear(2010);
		services.save(car);
		Assert.assertNotNull(services.get(car.getId()));

		Car car2 = services.get(car.getId());
		Assert.assertEquals(car2.getId(), car.getId());
		Assert.assertEquals(car2.getReleaseYear(), car.getReleaseYear());
		Assert.assertEquals(car2.getModel(), car.getModel());
		Assert.assertEquals(car2.getLegalEntity(), car.getLegalEntity());
		Assert.assertEquals(car2.getStatus(), car.getStatus());

		list = services.getAll();
		Assert.assertNotNull(list);

		services.remove(car.getId());

		Assert.assertNull(services.get(car.getId()));
	}
}
