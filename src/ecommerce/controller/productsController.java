package ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.entity.Cart;

@Controller
public class productsController {
public Cart cart;
	
	@RequestMapping(value = "productsPage", method = RequestMethod.GET)
	public String productsPage() {
		if(cart == null) {
			cart = new Cart();
		}
		return "products";
	}
	
	@RequestMapping(value = "addCart", method = RequestMethod.POST)
	public String addCart_Item(@RequestParam int quantity, @RequestParam int id, Model model) {
		if( quantity <= 0) {
			model.addAttribute("state", "La quantità deve essere almeno 1");
			return "products";
		} else {
			cart.addItem(id, quantity);
			model.addAttribute("cart", cart);
			return "products";
		}
	}
	@RequestMapping(value = "cartView", method = RequestMethod.GET)
	public String cartView(Model model) {
		model.addAttribute("cart",cart);
		return "products";
	}
}
