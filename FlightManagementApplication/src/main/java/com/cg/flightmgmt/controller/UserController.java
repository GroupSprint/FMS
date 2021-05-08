package com.cg.flightmgmt.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.IUserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
@Autowired
IUserService userservice;
	
	@PostMapping(path="/create")
	public ResponseEntity<User> addUse(@RequestBody User user){
		User user1 = userservice.addUser(user);
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
	
	@PutMapping(path="/validate")
	public ResponseEntity<User> validateUser(@RequestParam("userId") BigInteger userId, 
			@RequestParam("password") String password, 
			@RequestParam("userType") String userType) throws UserNotFoundException{
		User user1 = new User();
		user1.setUserId(userId);
		user1.setPassword(password);
		user1.setUserType(userType);
		User usernext = userservice.validateUser(user1);
		return new ResponseEntity<User>(usernext,HttpStatus.OK);
	}
	
	@PutMapping(path="/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User user)throws UserNotFoundException{
			User userData = userservice.updateUser(user);
			if(userData==null) {
				throw new UserNotFoundException();
			}
			return new ResponseEntity<User>(userData,HttpStatus.OK);
		}
	@DeleteMapping(path="/removeuser/{userId}")
	public ResponseEntity<User> removeuser(@PathVariable BigInteger userId)throws UserNotFoundException{
		User user1 = userservice.removeUser(userId);
		if(user1==null) {
			throw new UserNotFoundException();
		}
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
}

