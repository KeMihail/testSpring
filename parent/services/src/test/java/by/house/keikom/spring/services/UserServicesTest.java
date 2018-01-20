package by.house.keikom.spring.services;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.house.keikom.spring.dao.dbmodel.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class UserServicesTest extends AbstractServicesImpl {

	private final Logger LOGGER = LoggerFactory.getLogger(UserServicesTest.class);
	@Autowired
	private IUserServices services;
	private List<User> list;

	@Test
	public void testGRUD() throws ParseException {
		User user = new User();
		try {
			services.save(user);
			Assert.fail();
		} catch (Exception e) {
			LOGGER.debug("Error save");
		}
		user = createUser();
		services.save(user);
		Assert.assertNotNull(services.getById(user.getId()));

		User user1 = services.getById(user.getId());

		Assert.assertEquals(user1.getName(), user.getName());
		Assert.assertEquals(user1.getLastName(), user.getLastName());
		Assert.assertEquals(user1.getEmail(), user.getEmail());
		Assert.assertEquals(user1.getPhone_number(), user.getPhone_number());
		Assert.assertEquals(user1.getId(), user.getId());

		user.setName("Олег");
		services.save(user);
		Assert.assertNotNull(user);

		User user2 = services.getById(user.getId());
		Assert.assertEquals(user2.getName(), user.getName());
		Assert.assertEquals(user2.getLastName(), user.getLastName());
		Assert.assertEquals(user2.getEmail(), user.getEmail());
		Assert.assertEquals(user2.getPhone_number(), user.getPhone_number());
		Assert.assertEquals(user2.getId(), user.getId());

		list = services.getAll();
		Assert.assertNotNull(list);

		services.delete(user.getId());
		Assert.assertNull(services.getById(user.getId()));

	}
}
