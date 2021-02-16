package it.beije.ananke.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.model.dao.JpaDao;
import it.beije.ananke.ecommerce.repositories.OrderItemRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;

@Controller
public class OrderController {
	public static final String OPEN = "open";
	public static final String CLOSE = "close";
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository OrderItemRepository;
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public void addToChart(@RequestParam int id, @RequestParam int quantity, @RequestParam double price, HttpSession session) {
		
		User u = (User) session.getAttribute("user");
		if(u!=null) {
			Order o = orderRepository.findByUserIdAndState(u.getId(), OPEN);
			if(o == null) {
				o = new Order();
				o.setUserId(u.getId());
				o.setState(OPEN);
				orderRepository.save(o);
			} 
			
			Integer orderId = o.getId();
			
			
		}
		

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
