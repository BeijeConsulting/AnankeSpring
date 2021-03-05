package it.beije.ananke.ecommerce.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.model.User;

@Service
public class UserService {
	
	public boolean checkSession (HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null) {
			return true;
		}
		return false;
	}

}
