package it.beije.ananke.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.User;

@Controller
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		System.out.println("In home");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null) {
			model.addAttribute("userId", user.getId());
			if(user.getEmail().endsWith("admin.com")) {
				model.addAttribute("title","admin");
			}
		}
		return "home";
	}
	
}
