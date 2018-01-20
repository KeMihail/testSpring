package by.house.keikom.spring.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.house.keikom.spring.dao.dbmodel.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class ProductServicesTest extends AbstractServicesImpl {

	@Autowired
	private IProductServices services;

	private final Logger LOGGER = LoggerFactory.getLogger(ProductServicesTest.class);
	private List<Product> list;

	@Test
	public void testGRUD() {
		Product product = new Product();

		try {
			services.save(product);
			Assert.fail();
		} catch (Exception e) {
			LOGGER.error("Error");
		}

		product = createProduct();
		services.save(product);
		Assert.assertNotNull(services.getById(product.getId()));

		Product product1 = services.getById(product.getId());
		Assert.assertEquals(product1.getId(), product.getId());
		Assert.assertEquals(product1.getName(), product.getName());
		Assert.assertEquals(product1.getManufacturer(), product.getManufacturer());
		Assert.assertEquals(product1.getPrice(), product.getPrice());
		Assert.assertEquals(product1.getDeleted(), product.getDeleted());

		product.setName("Молоко");
		services.save(product);
		Assert.assertNotNull(services.getById(product.getId()));

		Product product2 = services.getById(product.getId());
		Assert.assertEquals(product2.getId(), product.getId());
		Assert.assertEquals(product2.getName(), product.getName());
		Assert.assertEquals(product2.getManufacturer(), product.getManufacturer());
		Assert.assertEquals(product2.getPrice(), product.getPrice());
		Assert.assertEquals(product2.getDeleted(), product.getDeleted());

		list = services.getAll();
		Assert.assertNotNull(list);

		services.delete(product.getId());
		Assert.assertNull(services.getById(product.getId()));
	}
}
