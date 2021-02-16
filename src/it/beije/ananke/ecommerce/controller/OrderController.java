package it.beije.ananke.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.model.dao.JpaDao;

@Controller
public class OrderController {
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public void addToChart(@RequestParam int id, @RequestParam int quantity, @RequestParam double price, HttpSession session) {
		
		User u = (User) session.getAttribute("user");
		if(u!=null) {
			
		}
		JpaDao dao = new JpaDao();
		OrderItem oi = new OrderItem();
		//....
		
		dao.persist((Object) oi);

	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public void addToChart(HttpSession session) {
		
		JpaDao dao = new JpaDao();
		OrderItem oi = new OrderItem();
		//....
		session.getAttribute("name");
		
		dao.persist((Object) oi);

	}
	
	
}
