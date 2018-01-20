package by.itacademy.keikom.taxi.services.impl;

import by.itacademy.keikom.taxi.dao.dbmodel.LegalEntity;

public class Test {

	public static void main(String[] args) {

		LegalEntity legalEntity = new LegalEntity();
		legalEntity.setName("ООО Такси");
		legalEntity.setAddress("г.Гродно");
		legalEntity.setEmail("Taxi@tut.by");
		legalEntity.setPhoneNumber("80297875512");

		LegalEntityServicesImpl serv = new LegalEntityServicesImpl();
		serv.save(legalEntity);
		System.out.println(serv.getById(legalEntity.getId()));
	}

}
