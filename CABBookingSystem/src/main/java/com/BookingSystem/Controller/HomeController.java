package com.BookingSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookingSystem.Entity.User;
import com.BookingSystem.Service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	UserService userService;

	@PostMapping("/login/auth")
	public String returnHomePage(Model model, User user) {
		List<User> users = userService.validateLogin(user);
		User userObj = new User();
		if (users.size() > 0) {
			userObj = users.get(0);
			if (user.getUserName().equals(userObj.getUserName()) && user.getPassword().equals(userObj.getPassword())) {
				return "Home";
			} else {
				model.addAttribute("login_error", "Invalid user credentials");
				return "SignIn";
			}
		} else {
			model.addAttribute("login_error", "Invalid user credentials");
			return "SignIn";
		}
	}

	@RequestMapping(path = { "/login" })
	public String Login(Model model) {
		model.addAttribute(new User());
		return "SignIn";

	}

}
