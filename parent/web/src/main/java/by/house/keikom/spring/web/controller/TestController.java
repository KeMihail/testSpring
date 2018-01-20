package by.house.keikom.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("/sample")
public class TestController {

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcomePage(ModelAndView model) {
		model.addObject("greeting", "Hello person");
		return "welcome";
	}
}
