package it.beije.ananke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.ananke.model.Order;
import it.beije.ananke.model.OrderItem;
import it.beije.ananke.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/addToCartPost", method = RequestMethod.POST)
	public String orderItemsGet(@RequestParam Integer quantity,@RequestParam Integer userId
			,@RequestParam Integer productId ,Model model) {
		
		System.out.println("Quantity : "+quantity +" productId : "+productId );
		model.addAttribute("quantity",quantity);
		model.addAttribute("productId",productId);
		if( quantity <= 0) {
			model.addAttribute("state", "quantity should be atleast 1");
			return "userPersonalPage";
		}
		else {
			Order order = orderService.findByUserId(userId);
			if(order!=null) {
				//order is present ,now add products i.e order_item.....tomorrow start from here
			}
			
			
			return "userPersonalPage";
		}
		
		
	}
}
