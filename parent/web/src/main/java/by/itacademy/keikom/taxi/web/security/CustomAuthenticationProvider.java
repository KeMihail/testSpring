package by.itacademy.keikom.taxi.web.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.AuthenticationUser;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.services.IAuthenticationUserServices;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	IAuthenticationUserServices authenticationServices;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String login = authentication.getPrincipal() + "";
		String password = authentication.getCredentials() + "";

		AuthenticationUser authenticationUser = authenticationServices.loadByLogin(login);
		User user = authenticationUser.getUser();

		if (!authenticationUser.getLogin().equals(login) && !authenticationUser.getPassword().equals(password)) {
			throw new BadCredentialsException("1000");
		}
		if (user.getDeleted().equals(true)) { // locked user
			throw new DisabledException("1001");
		}

		List<SimpleGrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"),
				new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
		// roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
		return new UsernamePasswordAuthenticationToken(login, password, roles);

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
