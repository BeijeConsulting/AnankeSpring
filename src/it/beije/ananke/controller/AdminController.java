package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.ananke.model.User;
import it.beije.ananke.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/adminAuthGet", method = RequestMethod.GET)
	public String getAdminPage() {
		return "adminAuth";
	}
	@RequestMapping(value = "/adminHomePage", method = RequestMethod.GET)
	public String adminPersonalPage() {
		return "adminSuccessfullLogIn";
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		List<User> allUsers = new ArrayList<>();
		allUsers = userService.findAll();
		model.addAttribute("allUsers", allUsers);
		return "getAllUsers";
	}
	@RequestMapping(value = "/adminPersonalPage", method = RequestMethod.POST)
	public String adminPersonalPage(@RequestParam String email, @RequestParam String password) {
		
		if(email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("123")) {
			return "adminSuccessfullLogIn";	
		}
		else 
			return "logInFailed";
	}
	@RequestMapping(value = "logOutAdmin" , method =RequestMethod.GET)
	public String logOutAdmin(HttpSession session)
	{
		session.invalidate();
		return "mainPage";
	}

}
