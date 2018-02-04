package by.itacademy.keikom.taxi.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.itacademy.keikom.taxi.dao.dbmodel.LegalEntity;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;

public interface ILegalEntityServices {

	@Transactional
	LegalEntity save(LegalEntity legalEntity);

	@Transactional
	void delete(Integer id);

	LegalEntity getById(Integer id);

	public List<LegalEntity> getAll();

	public List<LegalEntity> getAll(final String sortColumn, final boolean sortAscending, final int limit,
			final int offset);

	public Integer getCount();
}
