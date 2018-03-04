package com.channelit.empManager.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class EmployeeUserDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -274540187167294579L;
	
	private Employee currentUser;
	
	private List<GrantedAuthority> grantedAuths = new ArrayList<>();
	
	public  EmployeeUserDetail(Employee empUser) {
		// TODO Auto-generated constructor stub
		this.currentUser = empUser;
		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuths;
	}
	
	public void setAuthorities(List<GrantedAuthority> authorities)
	{
		this.grantedAuths = authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.currentUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public Employee getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Employee currentUser) {
		this.currentUser = currentUser;
	}

}
