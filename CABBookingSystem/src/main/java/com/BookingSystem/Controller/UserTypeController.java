package com.BookingSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookingSystem.Entity.UserType;
import com.BookingSystem.Repository.UserTypeRepository;
import com.BookingSystem.Service.UserTypeServie;

@Controller
@RequestMapping("/usertype")
public class UserTypeController {
	@Autowired
	UserTypeServie userTypeService;
	@Autowired
	UserTypeRepository userTypeRepository;
	
	
	@RequestMapping("/userstypes")
	public String getAllUserType(Model model) {
		List<UserType> userType = (List<UserType>) userTypeService.getAllUserType();
		model.addAttribute("user_type", userType);
		
		return "UserType";
	}
	@GetMapping("/userType/get/{userTypeId}")
	public ResponseEntity<UserType> getAllTrip(@PathVariable Integer userTypeId) {
		if (userTypeRepository.findById(userTypeId).isPresent())
			return new ResponseEntity<>(userTypeRepository.findById(userTypeId).get(), HttpStatus.OK);
		else
			return null;
	}

}
