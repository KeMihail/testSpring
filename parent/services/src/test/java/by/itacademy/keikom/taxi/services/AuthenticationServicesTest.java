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

import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.dao.dbmodel.User;

public class AuthenticationServicesTest extends AbstractServicesTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServicesTest.class);

	@Autowired
	private IAuthenticationServices services;

	private List<Authentication> list;

	@Autowired
	private IUserServices userServices;
	private User user;

	@PostConstruct
	public void prepareTestData() throws ParseException {
		user = createUser();
		userServices.save(user);
	}

	@PreDestroy
	public void cleanTestData() {
		userServices.remove(user.getId());
	}

	@Test
	public void testGRUD() {

		Authentication authentication = null;

		try {
			services.save(authentication);
			Assert.fail();
		} catch (Exception e) {
			LOGGER.error("you cannot save the object entered all of the data");
		}

		authentication = createAuthentication(user);
		services.save(authentication);
		Assert.assertNotNull(services.get(authentication.getUserId()));

		Authentication authentication1 = services.get(authentication.getUserId());
		Assert.assertEquals(authentication1.getUserId(), authentication.getUserId());
		Assert.assertEquals(authentication1.getLogin(), authentication.getLogin());
		Assert.assertEquals(authentication1.getPassword(), authentication.getPassword());

		authentication.setLogin("login_update");
		services.save(authentication);
		Assert.assertNotNull(services.get(authentication.getUserId()));

		Authentication authentication2 = services.get(authentication.getUserId());
		Assert.assertEquals(authentication2.getUserId(), authentication.getUserId());
		Assert.assertEquals(authentication2.getLogin(), authentication.getLogin());
		Assert.assertEquals(authentication2.getPassword(), authentication.getPassword());

		list = services.getAll();
		Assert.assertNotNull(list);

		services.remove(authentication.getUserId());
		Assert.assertNull(services.get(authentication.getUserId()));
	}
}
