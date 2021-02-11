package ecommerce.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class login {

	
	@RequestMapping (value = "/loginpage", method = RequestMethod.GET)
	public String Login(HttpRequest request) {
		return "login";
	}
}
