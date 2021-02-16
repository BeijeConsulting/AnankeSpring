package it.beije.ananke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.UserRepository;

@Controller
public class MyController {
	
	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getString() {
		return "mainPage";
	}

	@RequestMapping(value = "/getRegistrationPage", method = RequestMethod.GET)
	public String form() {
		System.out.println("get form...");
		return "registrationForm";
	}

	@RequestMapping(value = "/registrationPost", method = RequestMethod.POST)
	public String postContatto(User user, Model model) {
		System.out.println("postContatto : " + user);
		userRepository.save(user);
		model.addAttribute("contatto", user);
		return "done";
	}
	
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

}
