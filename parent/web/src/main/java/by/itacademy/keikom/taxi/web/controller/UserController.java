package by.itacademy.keikom.taxi.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.services.IUserServices;
import by.itacademy.keikom.taxi.web.converter.UserFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.UserToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.UserDTO;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserServices userService;

	@Autowired
	private UserToDTOConverter toDTOConverter;;

	@Autowired
	private UserFromDTOConverter fromDTOConverter;;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList() {
		final Map<String, List<UserDTO>> viewModel = new HashMap<String, List<UserDTO>>();
		final List<User> dbModels = userService.getAll();
		final List<UserDTO> userDTOs = dbModels.stream().map(toDTOConverter).collect(Collectors.toList());
		viewModel.put("users", userDTOs);
		return new ModelAndView("user.list", viewModel);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("user.edit", "userForm", new UserDTO());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute("userForm") final UserDTO dto, final ModelMap model) {
		final User user = fromDTOConverter.apply(dto);
		userService.save(user);
		return "redirect:/user";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		userService.delete(id);
		return "redirect:/user";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final UserDTO dto = toDTOConverter.apply(userService.getById(id));
		return new ModelAndView("user.details", "user", dto);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final UserDTO dto = toDTOConverter.apply(userService.getById(id));
		return new ModelAndView("user.edit", "userForm", dto);
	}
}
