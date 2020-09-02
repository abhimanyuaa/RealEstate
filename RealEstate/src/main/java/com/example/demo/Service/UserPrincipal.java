package com.example.demo.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Model.User;


public class UserPrincipal implements UserDetails {

	
	private static final long serialVersionUID = 1L;

	private User user;
	 List<GrantedAuthority> list ;
	 
	 public UserPrincipal() {
			super();
			// TODO Auto-generated constructor stub
		}
	 
	 
	public UserPrincipal(User user) {
		super();
		this.user = user;
		this.list= Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority :: new)
				.collect(Collectors.toList());
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
