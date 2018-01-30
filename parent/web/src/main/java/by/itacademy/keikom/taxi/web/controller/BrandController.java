package by.itacademy.keikom.taxi.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.keikom.taxi.dao.dbmodel.Brand;
import by.itacademy.keikom.taxi.services.IBrandServices;
import by.itacademy.keikom.taxi.web.converter.BrandToDTOConverter;
import by.itacademy.keikom.taxi.web.dto.BrandDTO;
import by.itacademy.keikom.taxi.web.converter.BrandFromDTOConverter;

@Controller
@RequestMapping(value = "/brand")
public class BrandController {

	@Autowired
	private IBrandServices brandServices;
	@Autowired
	private BrandToDTOConverter toDTOConverter;
	@Autowired
	private BrandFromDTOConverter fromDTOConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList() {

		final Map<String, List<BrandDTO>> viewModel = new HashMap<String, List<BrandDTO>>();
		final List<Brand> dbModels = brandServices.getAll();
		final List<BrandDTO> brandDTOs = dbModels.stream().map(toDTOConverter).collect(Collectors.toList());
		viewModel.put("brandAll", brandDTOs);
		return new ModelAndView("brand.list", viewModel);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("brand.edit", "brandForms", new BrandDTO());
	}

	public String save() {
		return null;

	}
}
