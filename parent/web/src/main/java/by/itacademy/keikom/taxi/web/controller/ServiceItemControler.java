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

import by.itacademy.keikom.taxi.dao.dbmodel.ServiceItem;
import by.itacademy.keikom.taxi.dao.dbmodel.ServiceItem_;
import by.itacademy.keikom.taxi.dao.filter.ServiceItemFilter;
import by.itacademy.keikom.taxi.services.IServiceItem;
import by.itacademy.keikom.taxi.web.converter.ServiceItemFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.ServiceItemToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.ServiceItemDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/service")
public class ServiceItemControler {

	private static final String LOCAL_LIST_MODEL_NAME = "serviceItemListModel";

	@Autowired
	private IServiceItem servicesServiceItem;

	@Autowired
	private ServiceItemFromDTOConverter fromDTOConverter;

	@Autowired
	private ServiceItemToDTOConverter toDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<ServiceItemDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("id"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<ServiceItemDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);

		ServiceItemFilter serviceItemFilter = buildFilter(listModel);

		final List<ServiceItem> currentPageList = servicesServiceItem.getAll(serviceItemFilter);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(servicesServiceItem.getCount(serviceItemFilter));

		final ModelAndView mv = new ModelAndView("serviceitem.list");
		return mv;
	}

	private ServiceItemFilter buildFilter(ListModel<ServiceItemDTO> listModel) {

		SortModel sortModel = listModel.getSort();
		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);

		ServiceItemFilter serviceItemFilter = new ServiceItemFilter();
		serviceItemFilter.setLimit(listModel.getItemsPerPage());
		serviceItemFilter.setOffset(offset);
		serviceItemFilter.setSortOrder(sortModel.isAscending());

		SingularAttribute sortAttribute;
		switch (sortModel.getColumn()) {
		case "id":
			sortAttribute = ServiceItem_.id;
			break;
		case "car":
			sortAttribute = ServiceItem_.car;
			break;
		case "item":
			sortAttribute = ServiceItem_.item;
			break;
		case "summa":
			sortAttribute = ServiceItem_.summa;
			break;
		default:
			throw new IllegalArgumentException("unsupported sort property:" + sortModel.getColumn());
		}
		serviceItemFilter.setSortProperty(sortAttribute);
		return serviceItemFilter;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("serviceitem.edit", "serviceitemForm", new ServiceItemDTO());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("serviceitemForm") final ServiceItemDTO serviceItemForm,
			final BindingResult result) {
		if (result.hasErrors()) {
			return "serviceitem.edit";
		} else {
			final ServiceItem serviceItem = fromDTOConverter.apply(serviceItemForm);
			servicesServiceItem.save(serviceItem);
			return "redirect:/serviceitem";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		servicesServiceItem.remove(id);
		return "redirect:/serviceitem";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final ServiceItemDTO dto = toDTOConverter.apply(servicesServiceItem.get(id));
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("serviceitemForm", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("serviceitem.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final ServiceItemDTO dto = toDTOConverter.apply(servicesServiceItem.get(id));
		return new ModelAndView("serviceitem.edit", "serviceitemForm", dto);
	}
}
