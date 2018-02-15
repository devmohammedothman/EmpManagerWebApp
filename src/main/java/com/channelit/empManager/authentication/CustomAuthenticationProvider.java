package com.channelit.empManager.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.channelit.empManager.service.EmployeeService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider 
{

	@Autowired
	EmployeeService loginService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		if(authorizedUser(userName, password))
		{
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(()-> {return "AUTH_USER";});
			//grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
			System.out.println(auth.getAuthorities());
			return auth;
		}
		else
		{
			throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");
		}
	}
	
	private boolean authorizedUser(String userName,String password)
	{
		System.out.println("username is :" + userName+" and password is "+password );
		if(!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password))
		{
			if(loginService.loginEmployee(userName, password) != null)
				return true;
		}
		return false;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
