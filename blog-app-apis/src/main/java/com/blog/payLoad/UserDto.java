package com.blog.payLoad;

import jakarta.persistence.Column;

public class UserDto {
	
	private int id;
	private String name;
	private String email;
	private String about;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserDto(int id, String name, String email, String about, String password) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.about = about;
	this.password = password;
}
public UserDto() {
	super();
	// TODO Auto-generated constructor stub
}

}
