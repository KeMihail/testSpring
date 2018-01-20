package by.itacademy.keikom.taxi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index"; // tiles definition name.
						// webapp/WEB-INF/tiles-definitions/views.xml
	}
}
