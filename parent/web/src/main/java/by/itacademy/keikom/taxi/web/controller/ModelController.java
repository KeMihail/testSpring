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

import by.itacademy.keikom.taxi.dao.dbmodel.Model;
import by.itacademy.keikom.taxi.services.IModelServices;
import by.itacademy.keikom.taxi.web.converter.ModelFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.ModelToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.ModelDTO;
import by.itacademy.keikom.taxi.web.util.ListModel;
import by.itacademy.keikom.taxi.web.util.SortModel;

@Controller
@RequestMapping(value = "/model")
public class ModelController {

	private static final String LOCAL_LIST_MODEL_NAME = "modelListModel";

	@Autowired
	private IModelServices servicesModel;

	@Autowired
	private ModelFromDTOConverter fromDTOConverter;

	@Autowired
	private ModelToDTOConverter toDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList(final HttpServletRequest req,
			@RequestParam(name = "sort", required = false) final String sort,
			@RequestParam(name = "page", required = false) final Integer pageNumber) {

		ListModel<ModelDTO> listModel;
		if (req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME) == null) {
			listModel = new ListModel<>();
			listModel.setSort(new SortModel("id"));
			req.getSession().setAttribute(LOCAL_LIST_MODEL_NAME, listModel);
		} else {
			listModel = (ListModel<ModelDTO>) req.getSession().getAttribute(LOCAL_LIST_MODEL_NAME);
		}

		req.getSession().setAttribute(ListModel.SESSION_ATTR_NAME, listModel);

		listModel.setSort(sort);
		listModel.setPage(pageNumber);

		final int offset = listModel.getItemsPerPage() * (listModel.getPage() - 1);
		final SortModel sortModel = listModel.getSort();
		final List<Model> currentPageList = servicesModel.getAll(sortModel.getColumn(), sortModel.isAscending(),
				listModel.getItemsPerPage(), offset);
		listModel.setList(currentPageList.stream().map(toDTOConverter).collect(Collectors.toList()));
		listModel.setTotalCount(servicesModel.getCount());

		final ModelAndView mv = new ModelAndView("model.list");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("model.edit", "modelForm", new ModelDTO());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("modelForm") final ModelDTO modelForm, final BindingResult result) {
		if (result.hasErrors()) {
			return "model.edit";
		} else {
			final Model model = fromDTOConverter.apply(modelForm);
			servicesModel.save(model);
			return "redirect:/model";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		servicesModel.delete(id);
		return "redirect:/model";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final ModelDTO dto = toDTOConverter.apply(servicesModel.getById(id));
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("modelForm", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("model.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final ModelDTO dto = toDTOConverter.apply(servicesModel.getById(id));
		return new ModelAndView("model.edit", "modelForm", dto);
	}

}
