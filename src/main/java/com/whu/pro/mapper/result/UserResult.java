package com.whu.pro.mapper.result;
import java.sql.Timestamp;


public class UserResult {
	private String id;
	private String username;
	private String password;
	private String email;
	private String loginip;
	private Timestamp logintime;
	private Timestamp passwordtime;
	private String random;
	private Integer sex;
	private String realname;
	private Integer role;
	private String sextext;
	private String roletext;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public Timestamp getLogintime() {
		return logintime;
	}
	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}
	public Timestamp getPasswordtime() {
		return passwordtime;
	}
	public void setPasswordtime(Timestamp passwordtime) {
		this.passwordtime = passwordtime;
	}
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
    
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getSextext() {
		return sextext;
	}
	public void setSextext(String sextext) {
		this.sextext = sextext;
	}
	public String getRoletext() {
		return roletext;
	}
	public void setRoletext(String roletext) {
		this.roletext = roletext;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
	
	
}
