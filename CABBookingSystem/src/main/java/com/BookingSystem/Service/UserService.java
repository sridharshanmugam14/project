package com.BookingSystem.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.BookingSystem.Entity.User;


public interface UserService {

	public List<User> getAllAbstractUser();

	public String insertAbstractUser(User user);
	
	public ResponseEntity<Object> updateAbractUser( Integer id,User user);
	
	public List<User> validateLogin(User user);
}
