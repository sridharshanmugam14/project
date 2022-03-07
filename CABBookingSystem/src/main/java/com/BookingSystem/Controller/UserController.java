package com.BookingSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookingSystem.Entity.User;
import com.BookingSystem.Entity.UserType;
import com.BookingSystem.Repository.UserRepository;
import com.BookingSystem.Service.UserService;
import com.BookingSystem.Service.UserTypeServie;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository abstractUserRepository;

	@Autowired
	UserTypeServie userTypeServie;

	@RequestMapping("/users")
	public String getAllAbstractUser(Model model) {
		List<User> user = (List<User>) userService.getAllAbstractUser();
		model.addAttribute("users", user);

		return "UserList";
	}

	@PostMapping("/createuser")
	public String insertAbstractUser(Model model, User user) {

		userService.insertAbstractUser(user);
		List<User> userObj = (List<User>) userService.getAllAbstractUser();
		model.addAttribute("users", userObj);

		return "UserList";
	}

	@RequestMapping(path = { "/insertuser", "/edit/{id}" })
	public String insetAbstractUser(Model model, @PathVariable("id") Optional<Integer> id) {
		if (id.isPresent()) {
			model.addAttribute("users");
		} else {
			model.addAttribute(new User());
			List<UserType> userTypes = userTypeServie.getAllUserType();
			model.addAttribute("userType", userTypes);
		}
		return "LoginAddUserList";

	}

	@GetMapping("/users/get/{id}")
	public ResponseEntity<User> getAllAbstractUser(@PathVariable int id) {
		if (abstractUserRepository.findById(id).isPresent())
			return new ResponseEntity<>(abstractUserRepository.findById(id).get(), HttpStatus.OK);
		else
			return null;
	}

	@DeleteMapping("/abstractuser/delete/{id}")
	public ResponseEntity<Object> deleteAbstractUser(@PathVariable int id) {
		if (abstractUserRepository.findById(id).isPresent()) {
			abstractUserRepository.deleteById(id);
			if (abstractUserRepository.findById(id).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified organization");
			else
				return ResponseEntity.ok("Successfully deleted the specified organization");
		} else
			return ResponseEntity.unprocessableEntity().body("Specified organization not present");
	}

	@PutMapping("/user/update/{id}")
	public ResponseEntity<Object> updateAbractUser(@PathVariable int id, @RequestBody User user) {
		return userService.updateAbractUser(id, user);
	}
}
