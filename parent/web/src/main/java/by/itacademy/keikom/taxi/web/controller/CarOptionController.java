package by.itacademy.keikom.taxi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import by.itacademy.keikom.taxi.services.ICarOptionServices;
import by.itacademy.keikom.taxi.web.converter.CarOptionFromDTOConverter;
import by.itacademy.keikom.taxi.web.converter.CarToDTOConverter;

public class CarOptionController {

	private static final String LOCAL_LIST_MODEL_NAME = "carOptionListModel";

	@Autowired
	private ICarOptionServices carOptionServices;

	@Autowired
	private CarOptionFromDTOConverter fromDTOConverter;

	@Autowired
	private CarToDTOConverter toDTOConverter;

}
