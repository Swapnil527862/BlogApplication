package com.blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Repository.UserRepo;
import com.blog.Service.UserService;
import com.blog.payLoad.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto user) {
		
		return null;
	}

	@Override
	public UserDto updateUser(UserDto User, Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getuserbyId(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}

}
