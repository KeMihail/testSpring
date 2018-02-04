package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.ILegalEntityDao;
import by.itacademy.keikom.taxi.dao.dbmodel.LegalEntity;
import by.itacademy.keikom.taxi.services.ILegalEntityServices;
import by.itacademy.keikom.taxi.services.exeption.NotValidPhoneNumberException;

@Service
public class LegalEntityServicesImpl extends AbstractServicesImpl implements ILegalEntityServices {

	@Autowired
	private ILegalEntityDao dao;

	@Override
	public LegalEntity save(LegalEntity legalEntity) {

		/*
		 * if (!validateEmailAddress(legalEntity.getEmail())) {
		 * legalEntity.setEmail(null); }
		 * 
		 * if (!validatePhoneNumber(legalEntity.getPhone_number())) { throw new
		 * NotValidPhoneNumberException(); }
		 */

		legalEntity.setModified(new Timestamp(new Date().getTime()));

		if (legalEntity.getId() != null) {
			dao.update(legalEntity);
		} else {
			legalEntity.setCreated(new Timestamp(new Date().getTime()));
			Integer id = dao.create(legalEntity);
			legalEntity.setId(id);
		}
		return legalEntity;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public LegalEntity getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<LegalEntity> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<LegalEntity> getAll(final String sortColumn, final boolean sortAscending, final int limit,
			final int offset) {
		final List<LegalEntity> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<LegalEntity>() {
			@Override
			public int compare(LegalEntity o1, LegalEntity o2) {
				if (sortAscending) {
					final LegalEntity temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("id".equals(sortColumn)) {
					return o1.getId().compareTo(o2.getId());
				} else if ("name".equals(sortColumn)) {
					return o1.getName().compareTo(o2.getName());
				} else if ("address".equals(sortColumn)) {
					return o1.getAddress().compareTo(o2.getAddress());
				} else if ("phoneNumber".equals(sortColumn)) {
					return o1.getPhone_number().compareTo(o2.getPhone_number());
				} else if ("email".equals(sortColumn)) {
					return o1.getEmail().compareTo(o2.getEmail());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
