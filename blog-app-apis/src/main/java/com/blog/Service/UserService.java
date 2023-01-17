package com.blog.Service;

import java.util.List;

import com.blog.Entities.User;
import com.blog.payLoad.UserDto;

public interface UserService {
	
	UserDto createUser (UserDto user);
	
	UserDto updateUser(UserDto User,Integer userid);
	
	UserDto getuserbyId(Integer userid);
	
	List<UserDto>getAllUsers();
	
	void deleteUser(Integer userId);
	
	

}
