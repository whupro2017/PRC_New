package com.whu.pro.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.whu.pro.mapper.result.TestUserResult;

public class MyUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TestUserResult userResult;
	public MyUserDetails(TestUserResult userResult)
	{
		this.userResult=userResult;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<MyGrantAuthority> sets = new HashSet<MyGrantAuthority>();
		MyGrantAuthority myGrantAuthority = new MyGrantAuthority(userResult.getRole());
		sets.add(myGrantAuthority);
		return sets;
	}


	public String getPassword() {
		// TODO Auto-generated method stub
		return userResult.getPassword();
	}


	public String getUsername() {
		// TODO Auto-generated method stub
		return userResult.getUser_name();
	}


	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
