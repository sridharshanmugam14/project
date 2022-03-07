package com.BookingSystem.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookingSystem.Entity.UserType;
import com.BookingSystem.Repository.UserTypeRepository;
import com.BookingSystem.Service.UserTypeServie;
@Service
public class UserTypeServiceImpl implements UserTypeServie{
	
	@Autowired
	UserTypeRepository userTypeRepository;

	@Override
	public List<UserType> getAllUserType() {
		// TODO Auto-generated method stub
		List<UserType> userType = new ArrayList<>();
		try {
			userType = (List<UserType>) userTypeRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userType;
		
	}
	
	
	}
	
	


