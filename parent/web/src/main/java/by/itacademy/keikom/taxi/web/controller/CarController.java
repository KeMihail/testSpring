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

import by.itacademy.keikom.taxi.dao.dbmodel.Car;
import by.itacademy.keikom.taxi.dao.dbmodel.Car_;
import by.itacademy.keikom.taxi.dao.filter.CarFilter;
import by.itacademy.keikom.taxi.services.ICarServices;
import by.itacademy.keikom.taxi.web.converter.CarFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.CarToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.CarDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/car")
public class CarController {

	private static final String LOCAL_LIST_MODEL_NAME = "carListModel";

	@Autowired
	private ICarServices servicesCar;

	@Autowired
	private CarFromDTOConverter fromDTOConverter;

	@Autowired
	private CarToDTOConverter toDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<CarDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("id"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<CarDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);

		CarFilter carFilter = buildFilter(listModel);

		final List<Car> currentPageList = servicesCar.getAll(carFilter);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(servicesCar.getCount(carFilter));

		final ModelAndView mv = new ModelAndView("car.list");
		return mv;
	}

	private CarFilter buildFilter(ListModel<CarDTO> listModel) {

		SortModel sortModel = listModel.getSort();
		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);

		CarFilter carFilter = new CarFilter();
		carFilter.setLimit(listModel.getItemsPerPage());
		carFilter.setOffset(offset);
		carFilter.setSortOrder(sortModel.isAscending());

		SingularAttribute sortAttribute;
		switch (sortModel.getColumn()) {
		case "id":
			sortAttribute = Car_.id;
			break;
		case "userId":
			sortAttribute = Car_.user;
			break;
		case "releaseYear":
			sortAttribute = Car_.releaseYear;
			break;
		case "modelId":
			sortAttribute = Car_.model;
			break;
		case "legalEntityId":
			sortAttribute = Car_.legalEntity;
			break;
		default:
			throw new IllegalArgumentException("unsupported sort property:" + sortModel.getColumn());
		}
		// carFilter.setSortProperty(sortAttribute);
		return carFilter;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		servicesCar.remove(id);
		return "redirect:/car";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final CarDTO dto = toDTOConverter.apply(servicesCar.get(id));
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("carForm", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("car.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final CarDTO dto = toDTOConverter.apply(servicesCar.get(id));
		return new ModelAndView("car.edit", "carForm", dto);
	}

}
