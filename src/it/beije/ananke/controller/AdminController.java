package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/adminAuthGet", method = RequestMethod.GET)
	public String getAdminPage() {
		return "adminAuth";
	}
	@RequestMapping(value = "/adminPersonalPage", method = RequestMethod.POST)
	public String adminPersonalPage(@RequestParam String email, @RequestParam String password) {
		User user = userRepository.findByEmail(email);
		if(user.getPassword()==password) {
			return "adminSuccessfullLogIn";	
		}
		else 
			return "logInFailed";
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		List<User> allUsers = new ArrayList<>();
		allUsers = userRepository.findAll();
		return "getAllUsers";
	}

}
