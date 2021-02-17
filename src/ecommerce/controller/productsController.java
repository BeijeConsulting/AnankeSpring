package ecommerce.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.entity.*;
import ecommerce.model.JPAManager;
import ecommerce.repository.OrderRepository;
import ecommerce.repository.Order_ItemRepository;
import ecommerce.repository.ProductRepository;
import ecommerce.services.OrderService;
import ecommerce.services.Order_ItemService;
import ecommerce.services.ProductService;

@Controller
public class productsController {
	@Autowired
	private ProductService product_service;
	@Autowired
	private OrderService order_service;
	@Autowired 
	private Order_ItemService order_item_service;
	public Cart cart;
	
	@RequestMapping(value = "productsPage", method = RequestMethod.GET)
	public String productsPage(Model model) {
		if(cart == null) {
			cart = new Cart();
		}
		List<Product> products = product_service.findAll();
		model.addAttribute("products", products );
		return "products";
	}
	
	@RequestMapping(value = "addCart", method = RequestMethod.POST)
	public String addCart_Item(@RequestParam int quantity, @RequestParam int id, Model model,HttpSession session) {
		if( quantity <= 0) {
			model.addAttribute("state", "La quantità deve essere almeno 1");
			return "products";
		} else {
			cart.addItem(id, quantity);
			List<Product> products = product_service.findAll();
			model.addAttribute("products", products );
			List<Cart_Item> cart_item = cart.getItems();
			session.setAttribute("cart_item", cart_item);
			
			return "products";
		}
	}
	
	
	@RequestMapping(value = "completeOrder", method = RequestMethod.GET)
	public String completeOrder(HttpSession session) {
		User u = (User) session.getAttribute("user");
		int id = order_service.addOrder(u, cart);
		order_item_service.addOrder_Item(id, cart);
		cart.getItems().clear();
		return "index";
	}
	
	@RequestMapping(value = "addProductPage", method = RequestMethod.GET)
	
	public String addProductPage() {
		return "insertProduct";
	}
	
	@RequestMapping(value = "insertProduct", method = RequestMethod.POST)
	public String addProduct(@RequestParam String name, @RequestParam String desc, @RequestParam Double price, Model model) {
	String state = product_service.addProduct(name, desc, price);
	model.addAttribute("state", state);
	return "index";
	}
	
	@GetMapping(value="cartPage")
	public String cartPage(Model model) {
		model.addAttribute("price", cart.getAmount());
		return "cart";
	}
	
	@GetMapping(value="deleteItem")
	public String deleteItem(@RequestParam int id,Model model){
		
		cart.deleteItem(id);
		model.addAttribute("price", cart.getAmount());
		return "cart";
	}
}
