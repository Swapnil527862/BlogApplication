package com.blog.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.Service.UserService;
import com.blog.payLoad.ApiResponce;
import com.blog.payLoad.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// post
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// Update User id
	@PutMapping("/updateUser/{userid}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userid") Integer uid) {
		UserDto updateUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.status(HttpStatus.OK).body(updateUser);
	}

	// delete User id
	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponce> deleteuser(@PathVariable Integer userid) {
		this.userService.deleteUser(userid);
		// return new ResponseEntity(Map.of("message","User deleted
		// Successfully"),HttpStatus.OK);
		return new ResponseEntity<ApiResponce>(new ApiResponce("User deleted Successfully", true), HttpStatus.OK);
	}

	// get All User
	@GetMapping("/getalluser")
	public ResponseEntity<List<UserDto>> getAllUser() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	// get user by id
	@GetMapping("/getuserbyid/{userid}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userid) {
		return ResponseEntity.ok(this.userService.getuserbyId(userid));
	}

}
