package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	@Autowired
	IUserRepository iuserrepository;
	
	@Override
	@Transactional
	public User addUser(User user) {
		return iuserrepository.save(user);
	}

	@Override
	@Transactional
	public User validateUser(User user) throws UserNotFoundException {
		Optional<User> us = iuserrepository.findById(user.getUserId());
		User user1 = us.get();
		if(!user.getPassword().equals(user1.getPassword())) {
			throw new UserNotFoundException();
		}
		else if(!user.getUserType().equals(user1.getUserType())){
			throw new UserNotFoundException();
		}
		else {
			return user;
		}
	}
	
	@Override
	@Transactional
	public User updateUser(User user) throws UserNotFoundException {
		Optional<User> us = iuserrepository.findById(user.getUserId());
		if(us.isPresent())
		{
			return iuserrepository.save(user);
		}
		else {
			throw new UserNotFoundException();
		}
	}

	@Override
	@Transactional
	public User removeUser(BigInteger userid) throws UserNotFoundException {
		Optional<User> us = iuserrepository.findById(userid);
		if(us.isPresent())
		{
			iuserrepository.deleteById(userid);
		return null;
	}
		else
			throw new UserNotFoundException();
	}

}
