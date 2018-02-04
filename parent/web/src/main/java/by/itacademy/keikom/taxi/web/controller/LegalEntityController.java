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

import by.itacademy.keikom.taxi.dao.dbmodel.LegalEntity;
import by.itacademy.keikom.taxi.services.ILegalEntityServices;
import by.itacademy.keikom.taxi.web.converter.LegalEntityFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.LegalEntityToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.LegalEntityDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/legalEntity")
public class LegalEntityController {

	private static final String LOCAL_LIST_MODEL_NAME = "legalEntityListModel";

	@Autowired
	private ILegalEntityServices legalEntityServises;

	@Autowired
	private LegalEntityToDTOConverter toDTOConverter;

	@Autowired
	private LegalEntityFromDTOConverter fromDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<LegalEntityDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("id"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<LegalEntityDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);
		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);
		final SortModel sortModel = listModel.getSort();
		final List<LegalEntity> currentPageList = legalEntityServises.getAll(sortModel.getColumn(),
				sortModel.isAscending(), listModel.getItemsPerPage(), offset);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(legalEntityServises.getCount());

		final ModelAndView mv = new ModelAndView("legalEntity.list");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("legalEntity.edit", "legalEntityForm", new LegalEntityDTO());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("legalEntityForm") final LegalEntityDTO legalEntityForm,
			final BindingResult result) {
		if (result.hasErrors()) {
			return "legalEntity.edit";
		} else {
			final LegalEntity legalEntity = fromDTOConverter.apply(legalEntityForm);
			legalEntityServises.save(legalEntity);
			return "redirect:/legalEntity";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		legalEntityServises.delete(id);
		return "redirect:/legalEntity";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final LegalEntityDTO dto = toDTOConverter.apply(legalEntityServises.getById(id));
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("legalEntityForm", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("legalEntity.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final LegalEntityDTO dto = toDTOConverter.apply(legalEntityServises.getById(id));
		return new ModelAndView("legalEntity.edit", "legalEntityForm", dto);
	}
}
