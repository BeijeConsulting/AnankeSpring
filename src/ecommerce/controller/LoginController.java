package ecommerce.controller;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import ecommerce.entity.User;
import ecommerce.model.JPAManager;

@Controller
public class LoginController {

	
	@RequestMapping(value ="loginPage", method = RequestMethod.GET)
	public String loginPage() {
		System.out.println("ci sono");
		return "login";
	}
	
	@RequestMapping(value ="auth", method = RequestMethod.POST)
	public String auth(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request, HttpServletResponse response ) {
	if(JPAManager.isUser(email, password)) {
			User u = JPAManager.getUser(email, password);
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return "index";
			
		} else {
		model.addAttribute("error", "Email o Password sbagliate, riprova oppure");
			
			return "login";
			
		}
	}
	@RequestMapping(value ="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
}
