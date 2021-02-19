package it.beije.ananke.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.Chart;
import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.ChartRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;

@Controller
public class ChartController {
	
	@Autowired 
	ChartRepository chartRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping(value = "/orderItems", method = RequestMethod.POST)
	public String orderItems(@RequestParam Integer id, HttpServletRequest request, Model model) {
		System.out.println("Showing items in order #" + id);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "home";
		}
		System.out.println(user==null);
		System.out.println("i'm here");
		Order order = orderRepository.findById(id).get();
		List<Chart> chart = chartRepository.findByOrderId(id);

		model.addAttribute("userId", user.getId());
		model.addAttribute("chart", chart);
		model.addAttribute("orderId", id);
		model.addAttribute("order", order);
		
		return "orderItems";
	}

}
