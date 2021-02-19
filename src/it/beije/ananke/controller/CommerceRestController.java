package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.model.Cart;
import it.beije.ananke.model.Order;
import it.beije.ananke.model.OrderItem;
import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.OrderItemRepository;
import it.beije.ananke.repository.OrderRepository;
import it.beije.ananke.repository.ProductRepository;
import it.beije.ananke.repository.UserRepository;
import it.beije.ananke.service.CartService;
import it.beije.ananke.service.UserService;

@RestController
@RequestMapping("/commerce")
public class CommerceRestController {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository pr;
	
	@Autowired 
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/users")
	public List<User> showUsers(){
		List<User> list = userRepository.findAll();
		return list;
	}
	
	
	@GetMapping("/orders/user/{id}")
	public List<Order> showProdcuts(@PathVariable Integer id){
		List<Order> list = orderRepository.findByStateAndUserId("open", id);
		return list;
	}
	
	
	@GetMapping("/cart/user/{id}")
	public Cart cartState(@PathVariable Integer id) {
		Cart cart = cartService.showCart(id + "");
		return cart;
	}
	
	
//	@PostMapping("/cart/product/{id}")
//	public Cart addToCart(@RequestBody User user, @PathVariable Integer id) {
//		Cart cart =  cartService.addToCart(user.getId() + "", id + "");
//		return cart;
//	}

	
	@PostMapping("cart/aggiungi/product/{id}")
	public Cart addToCart(@PathVariable Integer id, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
		User user = userRepository.getOne(1);
		
		Cart cart =  cartService.addToCart(user.getId() + "", id + "");
//		Cart cart =  cartService.addToCart(1 + "", id + "");
		return cart;
	}
	
	
//	@PostMapping("cart/aggiungi/product")
//	public Cart addToCart(@RequestBody Product product) {
//		
//		User user = userRepository.getOne(1);
//		
//		Cart cart =  cartService.addToCart(user.getId() + "", product.getId() + "");
//		return cart;
//	}
	
	
	@PostMapping("cart/rimuovi/orderitem/{id}")
	public Cart removeFromCart(@PathVariable Integer id, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
		User user = userRepository.getOne(1);
		
		Cart cart =  cartService.removeFromCart(user.getId() + "", id + "");
//		Cart cart =  cartService.addToCart(1 + "", id + "");
		return cart;
	}
	
	
	@PostMapping("/users/signup")
	public User addUser(@RequestBody User user) {
		User temp = userRepository.findByEmail(user.getEmail());
		if(temp != null) {
			return null;
		}else {
			userRepository.save(user);
			return user;
		}
	}
	
	@GetMapping("/login")
	public User login(@RequestBody User user) {
		User temp = userRepository.findByEmail(user.getEmail());
		if(temp.getPasword().equals(user.getPasword())) {
			return temp;
		}else {
			return null;
		}
	}
	
}
