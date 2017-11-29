package com.whu.pro.impl;

import org.springframework.security.core.GrantedAuthority;

public class MyGrantAuthority implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int role;
	public MyGrantAuthority(Integer role)
	{
		this.role=role;
	}
	public String getAuthority() {
		// TODO Auto-generated method stub
		return String.valueOf(role);
	}

	
}
