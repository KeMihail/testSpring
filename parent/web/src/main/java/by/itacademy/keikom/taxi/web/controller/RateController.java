package by.itacademy.keikom.taxi.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.metamodel.SingularAttribute;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate_;
import by.itacademy.keikom.taxi.dao.filter.RateFilter;
import by.itacademy.keikom.taxi.services.IRateServices;
import by.itacademy.keikom.taxi.web.converter.RateFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.RateToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.RateDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/rate")
public class RateController {

	private static final String LOCAL_LIST_MODEL_NAME = "rateListModel";

	@Autowired
	private IRateServices servicesRate;

	@Autowired
	private RateFromDTOConverter fromDTOConverter;

	@Autowired
	private RateToDTOConverter toDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<RateDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("id"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<RateDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);

		RateFilter rateFilter = buildFilter(listModel);

		final List<Rate> currentPageList = servicesRate.getAll(rateFilter);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(servicesRate.getCount(rateFilter));

		final ModelAndView mv = new ModelAndView("rate.list");
		return mv;
	}

	private RateFilter buildFilter(ListModel<RateDTO> listModel) {

		SortModel sortModel = listModel.getSort();
		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);

		RateFilter coverFilter = new RateFilter();
		coverFilter.setLimit(listModel.getItemsPerPage());
		coverFilter.setOffset(offset);
		coverFilter.setSortOrder(sortModel.isAscending());

		SingularAttribute sortAttribute;
		switch (sortModel.getColumn()) {
		case "id":
			sortAttribute = Rate_.id;
			break;
		case "name":
			sortAttribute = Rate_.name;
			break;
		case "priceLanding":
			sortAttribute = Rate_.priceLanding;
			break;
		case "priceKilometr":
			sortAttribute = Rate_.priceKilometr;
			break;
		case "priceMinuteWait":
			sortAttribute = Rate_.priceMinuteWait;
			break;
		default:
			throw new IllegalArgumentException("unsupported sort property:" + sortModel.getColumn());
		}
		coverFilter.setSortProperty(sortAttribute);
		return coverFilter;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		servicesRate.remove(id);
		return "redirect:/rate";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final RateDTO dto = toDTOConverter.apply(servicesRate.get(id));
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("rateForm", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("rate.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final RateDTO dto = toDTOConverter.apply(servicesRate.get(id));
		return new ModelAndView("rate.edit", "rateForm", dto);
	}
}
