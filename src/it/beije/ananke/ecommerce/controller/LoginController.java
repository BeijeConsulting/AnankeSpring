package it.beije.ananke.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.model.dao.JpaUser;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
		JpaUser dao = new JpaUser();
		boolean auth = dao.authenticate(email, password);
		User u = (User) dao.selectByField(User.class, "email", email).get(0);
		int id = u.getId();
		if(auth) {
			HttpSession session = request.getSession();
			session.setAttribute("user",u);
			return "home";
		}
		
		
		return "login/{id}";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login (HttpServletRequest request) {
		System.out.println("get login...");
		return "login";
	}
}
