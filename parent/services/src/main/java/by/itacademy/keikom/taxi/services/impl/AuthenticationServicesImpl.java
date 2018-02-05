package by.itacademy.keikom.taxi.services.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.keikom.taxi.dao.IAuthenticationDao;
import by.itacademy.keikom.taxi.dao.dbmodel.Authentication;
import by.itacademy.keikom.taxi.dao.dbmodel.Rate;
import by.itacademy.keikom.taxi.services.IAuthenticationServices;

@Service
public class AuthenticationServicesImpl implements IAuthenticationServices {

	@Autowired
	private IAuthenticationDao dao;

	@Override
	public Authentication save(Authentication authentication) {

		authentication.setModified(new Timestamp(new Date().getTime()));

		if (authentication.getCreated() != null) {
			dao.update(authentication);
		} else {
			authentication.setCreated(new Timestamp(new Date().getTime()));
			dao.create(authentication);
		}
		return authentication;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Authentication getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Authentication> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer getCount() {
		return getAll().size(); // FIXME: it is invalid implementation. use the
								// 'select count from...' SQL query from DAO
								// layer
	}

	@Override
	public List<Authentication> getAll(final String sortColumn, final boolean sortAscending, final int limit,
			final int offset) {
		final List<Authentication> all = getAll();

		// FIXME: Do not use code below. use an appropriate DAO method instead:
		// return dao.getAll(sortColumn,sortAscending,limit,offset)

		Collections.sort(all, new Comparator<Authentication>() {
			@Override
			public int compare(Authentication o1, Authentication o2) {
				if (sortAscending) {
					final Authentication temp = o1;
					o1 = o2;
					o2 = temp;
				}

				if ("userId".equals(sortColumn)) {
					return o1.getUserId().compareTo(o2.getUserId());
				} else if ("login".equals(sortColumn)) {
					return o1.getLogin().compareTo(o2.getLogin());
				} else if ("password".equals(sortColumn)) {
					return o1.getPassword().compareTo(o2.getPassword());
				}
				throw new IllegalArgumentException("unsupported sort column:" + sortColumn);
			}
		});

		return all.subList(Math.min(offset, all.size()), Math.min(offset + limit, all.size()));
	}
}
