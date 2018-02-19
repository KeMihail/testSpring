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

import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption;
import by.itacademy.keikom.taxi.dao.dbmodel.Car2CarOption_;
import by.itacademy.keikom.taxi.dao.filter.Car2CarOptionFilter;
import by.itacademy.keikom.taxi.services.ICar2CarOptionServices;
import by.itacademy.keikom.taxi.web.converter.Car2CarOptionFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.Car2CarOptionToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.Car2CarOptionDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/car2CarOption")
public class Car2OptionController {

	private static final String LOCAL_LIST_MODEL_NAME = "Car2CarOptionListModel";

	@Autowired
	private ICar2CarOptionServices servicesCar2CarOption;

	@Autowired
	private Car2CarOptionFromDTOConverter fromDTOConverter;

	@Autowired
	private Car2CarOptionToDTOConverter toDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<Car2CarOptionDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("carId"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<Car2CarOptionDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);

		Car2CarOptionFilter car2CarOptionFilter = buildFilter(listModel);

		final List<Car2CarOption> currentPageList = servicesCar2CarOption.getAll(car2CarOptionFilter);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(servicesCar2CarOption.getCount(car2CarOptionFilter));

		final ModelAndView mv = new ModelAndView("car2CarOptionDTO.list");
		return mv;
	}

	private Car2CarOptionFilter buildFilter(ListModel<Car2CarOptionDTO> listModel) {

		SortModel sortModel = listModel.getSort();
		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);

		Car2CarOptionFilter car2CarOptionFilterFilter = new Car2CarOptionFilter();
		car2CarOptionFilterFilter.setLimit(listModel.getItemsPerPage());
		car2CarOptionFilterFilter.setOffset(offset);
		car2CarOptionFilterFilter.setSortOrder(sortModel.isAscending());

		SingularAttribute sortAttribute;
		switch (sortModel.getColumn()) {
		case "carId":
			sortAttribute = Car2CarOption_.carId;
			break;
		case "carOptionId":
			sortAttribute = Car2CarOption_.carOptionId;
			break;
		default:
			throw new IllegalArgumentException("unsupported sort property:" + sortModel.getColumn());
		}
		car2CarOptionFilterFilter.setSortProperty(sortAttribute);
		return car2CarOptionFilterFilter;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("car2CarOption.edit", "car2CarOptionForm", new Car2CarOptionDTO());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("car2CarOptionForm") final Car2CarOptionDTO car2CarOptionForm,
			final BindingResult result) {
		if (result.hasErrors()) {
			return "car2CarOption.edit";
		} else {
			final Car2CarOption car2CarOption = fromDTOConverter.apply(car2CarOptionForm);
			servicesCar2CarOption.save(car2CarOption);
			return "redirect:/car2CarOption";
		}
	}

	/*
	 * @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET) public
	 * String delete(@PathVariable(name = "id", required = true) final Integer id) {
	 * servicesCar2Option.delete(id); return "redirect:/car2CarOption"; }
	 */

	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET) public
	 * ModelAndView viewDetails(@PathVariable(name = "id", required = true) final
	 * Integer id) { final Car2CarOptionDTO dto =
	 * toDTOConverter.apply(servicesCar2Option.getById(id)); final HashMap<String,
	 * Object> hashMap = new HashMap<>(); hashMap.put("car2CarOptionForm", dto);
	 * hashMap.put("readonly", true); return new ModelAndView("car2CarOption.edit",
	 * hashMap); }
	 */

	/*
	 * @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET) public
	 * ModelAndView edit(@PathVariable(name = "id", required = true) final Integer
	 * id) { final Car2CarOptionDTO dto =
	 * toDTOConverter.apply(servicesCar2Option.getById(id)); return new
	 * ModelAndView("car2CarOption.edit", "car2CarOptionForm", dto); }
	 */

}
