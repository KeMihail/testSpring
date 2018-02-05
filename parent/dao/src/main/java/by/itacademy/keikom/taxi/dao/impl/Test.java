package by.itacademy.keikom.taxi.dao.impl;

import org.springframework.stereotype.Repository;

import by.itacademy.keikom.taxi.dao.dbmodel.Model;

@Repository
public class Test {

	public static void main(String[] args) {

		ModelDaoImpl dao = new ModelDaoImpl();

		Model model = new Model();
		model = dao.getById(2);
		System.out.println(model);

	}

}
