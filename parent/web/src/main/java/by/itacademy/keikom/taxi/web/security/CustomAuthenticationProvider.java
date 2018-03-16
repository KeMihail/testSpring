package by.itacademy.keikom.taxi.web.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import by.itacademy.keikom.taxi.dao.dbmodel.UserAuthentication;
import by.itacademy.keikom.taxi.dao.dbmodel.User;
import by.itacademy.keikom.taxi.services.IUserAuthenticationServices;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	IUserAuthenticationServices authenticationServices;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String login = authentication.getPrincipal() + "";
		String password = authentication.getCredentials() + "";

		UserAuthentication authenticationUser = authenticationServices.loadByLogin(login);
		User user = authenticationUser.getUser();

		if (!authenticationUser.getLogin().equals(login) && !authenticationUser.getPassword().equals(password)) {
			throw new BadCredentialsException("1000");
		}
		if (user.getDeleted().equals(true)) { // locked user
			throw new DisabledException("1001");
		}

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_" + authenticationUser.getRole()));

		Integer userId = user.getId();

		return new ExtendedUsernamePasswordAuthenticationToken(userId, login, password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
