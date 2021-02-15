package ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.entity.*;

import ecommerce.repository.OrderRepository;
import ecommerce.repository.Order_ItemRepository;
import ecommerce.repository.ProductRepository;

@Controller
public class productsController {
	@Autowired
	private ProductRepository product_rep;
	@Autowired
	private OrderRepository order_rep;
	@Autowired Order_ItemRepository order_item_rep;
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
			
			return "products";
		}
	}
	@RequestMapping(value = "cartView", method = RequestMethod.GET)
	public String cartView(Model model) {
		model.addAttribute("cart",cart);
		return "products";
	}
	
	@RequestMapping(value = "completeOrder", method = RequestMethod.GET)
	public String completeOrder(HttpSession session) {
		User u = (User) session.getAttribute("user");
		Order o = new Order();
		o.setAmount(cart.getAmount());
		o.setState("closed");
		o.setUser_id(u.getId());
		order_rep.save(o);
		int order_id = o.getId();
		for(Cart_Item ci : cart.getItems()) {
			order_item_rep.save(ci.getOrder_Item(order_id));
			
		}
		return "index";
	}
	
	@RequestMapping(value = "addProductPage", method = RequestMethod.GET)
	
	public String addProductPage() {
		return "insertProduct";
	}
	
	@RequestMapping(value = "insertProduct", method = RequestMethod.POST)
	public String addProduct(@RequestParam String name, @RequestParam String desc, @RequestParam double price, Model model) {
	Product p = new Product();
	p.setDesc(desc);
	p.setName(name);
	p.setPrice(price);
	System.out.println(price);
	product_rep.save(p);
	
	model.addAttribute("state","done");
	return "admindashboard";
	}
	
}
