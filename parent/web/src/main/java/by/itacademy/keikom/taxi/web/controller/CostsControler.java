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

import by.itacademy.keikom.taxi.dao.dbmodel.Costs;
import by.itacademy.keikom.taxi.dao.dbmodel.Costs_;
import by.itacademy.keikom.taxi.dao.filter.CostsFilter;
import by.itacademy.keikom.taxi.services.ICostsServices;
import by.itacademy.keikom.taxi.web.converter.CostsFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.CostsToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.CostsDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/costs")
public class CostsControler {

	private static final String LOCAL_LIST_MODEL_NAME = "costsListModel";

	@Autowired
	private ICostsServices servicesCosts;

	@Autowired
	private CostsFromDTOConverter fromDTOConverter;

	@Autowired
	private CostsToDTOConverter toDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<CostsDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("carId"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<CostsDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);

		CostsFilter costsFilter = buildFilter(listModel);

		final List<Costs> currentPageList = servicesCosts.getAll(costsFilter);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(servicesCosts.getCount(costsFilter));

		final ModelAndView mv = new ModelAndView("costs.list");
		return mv;
	}

	private CostsFilter buildFilter(ListModel<CostsDTO> listModel) {

		SortModel sortModel = listModel.getSort();
		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);

		CostsFilter costsFilter = new CostsFilter();
		costsFilter.setLimit(listModel.getItemsPerPage());
		costsFilter.setOffset(offset);
		costsFilter.setSortOrder(sortModel.isAscending());

		SingularAttribute sortAttribute;
		switch (sortModel.getColumn()) {
		case "carId":
			sortAttribute = Costs_.carId;
			break;
		case "taxes":
			sortAttribute = Costs_.taxes;
			break;
		case "technicalInspection":
			sortAttribute = Costs_.technicalInspection;
			break;
		case "insurance":
			sortAttribute = Costs_.insurance;
			break;
		case "carService":
			sortAttribute = Costs_.carService;
			break;
		case "pretripInspection":
			sortAttribute = Costs_.pretripInspection;
			break;
		case "salaryDriver":
			sortAttribute = Costs_.salaryDriver;
			break;
		case "fuelConsumption":
			sortAttribute = Costs_.fuelConsumption;
			break;
		case "other":
			sortAttribute = Costs_.other;
			break;
		default:
			throw new IllegalArgumentException("unsupported sort property:" + sortModel.getColumn());
		}
		costsFilter.setSortProperty(sortAttribute);
		return costsFilter;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("costs.edit", "costsForm", new CostsDTO());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("costsForm") final CostsDTO costsForm, final BindingResult result) {
		if (result.hasErrors()) {
			return "costs.edit";
		} else {
			final Costs costs = fromDTOConverter.apply(costsForm);
			servicesCosts.save(costs);
			return "redirect:/costs";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		servicesCosts.remove(id);
		return "redirect:/costs";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final CostsDTO dto = toDTOConverter.apply(servicesCosts.get(id));
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("costsForm", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("costs.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final CostsDTO dto = toDTOConverter.apply(servicesCosts.get(id));
		return new ModelAndView("costs.edit", "costsForm", dto);
	}
}
