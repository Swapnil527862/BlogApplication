package com.blog.payLoad;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {
	
	private int id;
	@Valid
@NotEmpty(message = "please enter proper name")
	@Size(min = 3,max = 15)
	private String name;
@jakarta.validation.constraints.Email
@Size(min = 3,max = 25)
	private String email;
@NotNull
@Size(min = 3,max = 250)
	private String about;
@NotEmpty
@Size(min = 3,max = 15,message = "Password must be min 3 char and max 15 char")
/* @Pattern( regexp = ".") */
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
