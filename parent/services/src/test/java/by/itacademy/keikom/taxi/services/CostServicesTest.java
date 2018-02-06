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
import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.dao.dbmodel.LegalEntity;
import by.itacademy.keikom.taxi.dao.dbmodel.Model;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.services.impl.CostsServicesImpl;

public class CostServicesTest extends AbstractServicesTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(CostServicesTest.class);

	@Autowired
	private CostsServicesImpl services;
	private List<Costs> list;

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

		Costs costs = null;
		try {
			services.save(costs);
			Assert.fail();
		} catch (Exception e) {
			LOGGER.error("you cannot save the object entered all of the data");
		}
		costs = createCosts(car);
		services.save(costs);
		Assert.assertNotNull(services.get(costs.getCarId()));

		Costs costs1 = services.get(costs.getCarId());
		Assert.assertEquals(costs1.getCarId(), costs.getCarId());
		Assert.assertEquals(costs1.getCarService(), costs.getCarService());
		Assert.assertEquals(costs1.getFuelConsumption(), costs.getFuelConsumption());
		Assert.assertEquals(costs1.getInsurance(), costs.getInsurance());
		Assert.assertEquals(costs1.getOther(), costs.getOther());
		Assert.assertEquals(costs1.getPretripInspection(), costs.getPretripInspection());
		Assert.assertEquals(costs1.getSalaryDriver(), costs.getSalaryDriver());
		Assert.assertEquals(costs1.getTaxes(), costs.getTaxes());
		Assert.assertEquals(costs1.getTechnicalInspection(), costs.getTechnicalInspection());

		costs.setCarService(300.0);
		services.save(costs);
		Assert.assertNotNull(costs);

		Costs costs2 = services.get(costs.getCarId());
		Assert.assertEquals(costs2.getCarId(), costs.getCarId());
		Assert.assertEquals(costs2.getCarService(), costs.getCarService());
		Assert.assertEquals(costs2.getFuelConsumption(), costs.getFuelConsumption());
		Assert.assertEquals(costs2.getInsurance(), costs.getInsurance());
		Assert.assertEquals(costs2.getOther(), costs.getOther());
		Assert.assertEquals(costs2.getPretripInspection(), costs.getPretripInspection());
		Assert.assertEquals(costs2.getSalaryDriver(), costs.getSalaryDriver());
		Assert.assertEquals(costs2.getTaxes(), costs.getTaxes());
		Assert.assertEquals(costs2.getTechnicalInspection(), costs.getTechnicalInspection());

		list = services.getAll();
		Assert.assertNotNull(list);

		services.remove(costs.getCarId());
		Assert.assertNull(services.get(costs.getCarId()));
	}
}
