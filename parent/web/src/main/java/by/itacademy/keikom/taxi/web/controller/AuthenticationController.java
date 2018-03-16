package by.itacademy.keikom.taxi.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.metamodel.SingularAttribute;
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

import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser_;
import by.itacademy.keikom.taxi.dao.filter.AuthenticationFilter;
import by.itacademy.keikom.taxi.services.IUserAuthenticationServices;
import by.itacademy.keikom.taxi.web.converter.UserAuthenticationFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.UserAuthenticationToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.UserAuthenticationDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/authentication")
public class AuthenticationController {

	private static final String LOCAL_LIST_MODEL_NAME = "authenticationListModel";

	@Autowired
	private IUserAuthenticationServices servicesAuthentication;

	@Autowired
	private UserAuthenticationFromDTOConverter fromDTOConverter;

	@Autowired
	private UserAuthenticationToDTOConverter toDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<UserAuthenticationDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("userId"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<UserAuthenticationDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);

		AuthenticationFilter authenticationFilter = buildFilter(listModel);

		final List<UserAuthentication> currentPageList = servicesAuthentication.getAll(authenticationFilter);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(servicesAuthentication.getCount(authenticationFilter));

		final ModelAndView mv = new ModelAndView("authentication.list");
		return mv;
	}

	private AuthenticationFilter buildFilter(ListModel<UserAuthenticationDTO> listModel) {

		SortModel sortModel = listModel.getSort();
		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);

		AuthenticationFilter coverFilter = new AuthenticationFilter();
		coverFilter.setLimit(listModel.getItemsPerPage());
		coverFilter.setOffset(offset);
		coverFilter.setSortOrder(sortModel.isAscending());

		SingularAttribute sortAttribute;
		switch (sortModel.getColumn()) {
		case "userId":
			sortAttribute = AuthenticationUser_.user;
			break;
		case "login":
			sortAttribute = AuthenticationUser_.login;
			break;
		case "password":
			sortAttribute = AuthenticationUser_.password;
			break;
		default:
			throw new IllegalArgumentException("unsupported sort property:" + sortModel.getColumn());
		}
		coverFilter.setSortProperty(sortAttribute);
		return coverFilter;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("authentication.edit", "authenticationForm", new UserAuthenticationDTO());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("authenticationForm") final UserAuthenticationDTO authenticationForm,
			final BindingResult result) {
		if (result.hasErrors()) {
			return "authentication.edit";
		} else {
			final UserAuthentication authentication = fromDTOConverter.apply(authenticationForm);
			servicesAuthentication.save(authentication);
			return "redirect:/authentication";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		servicesAuthentication.remove(id);
		return "redirect:/authentication";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final UserAuthenticationDTO dto = toDTOConverter.apply(servicesAuthentication.get(id));
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("authenticationForm", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("authentication.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final UserAuthenticationDTO dto = toDTOConverter.apply(servicesAuthentication.get(id));
		return new ModelAndView("authentication.edit", "authenticationForm", dto);
	}
}
