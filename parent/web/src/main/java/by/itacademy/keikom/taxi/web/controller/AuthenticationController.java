package by.itacademy.keikom.taxi.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.services.IAuthenticationServices;
import by.itacademy.keikom.taxi.web.converter.AuthenticationFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.AuthenticationToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.AuthenticationDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/authentication")
public class AuthenticationController {

	private static final String LOCAL_LIST_MODEL_NAME = "authenticationListModel";

	@Autowired
	private IAuthenticationServices servicesAuthentication;

	@Autowired
	private AuthenticationFromDTOConverter fromDTOConverter;

	@Autowired
	private AuthenticationToDTOConverter toDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<AuthenticationDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("carId"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<AuthenticationDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);

		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);
		final SortModel sortModel = listModel.getSort();
		final List<Authentication> currentPageList = servicesAuthentication.getAll(sortModel.getColumn(),
				sortModel.isAscending(), listModel.getItemsPerPage(), offset);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(servicesAuthentication.getCount());

		final ModelAndView mv = new ModelAndView("authentication.list");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("authentication.edit", "authenticationForm", new AuthenticationDTO());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("authenticationForm") final AuthenticationDTO authenticationForm,
			final BindingResult result) {
		if (result.hasErrors()) {
			return "authentication.edit";
		} else {
			final Authentication authentication = fromDTOConverter.apply(authenticationForm);
			servicesAuthentication.save(authentication);
			return "redirect:/authentication";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		servicesAuthentication.delete(id);
		return "redirect:/authentication";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final AuthenticationDTO dto = toDTOConverter.apply(servicesAuthentication.getById(id));
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("authenticationForm", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("authentication.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final AuthenticationDTO dto = toDTOConverter.apply(servicesAuthentication.getById(id));
		return new ModelAndView("authentication.edit", "authenticationForm", dto);
	}

}
