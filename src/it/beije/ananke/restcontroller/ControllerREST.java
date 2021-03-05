package it.beije.ananke.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.entity.Order;
import it.beije.ananke.entity.OrderItem;
import it.beije.ananke.entity.Product;
import it.beije.ananke.entity.User;
import it.beije.ananke.service.OrderItemService;
import it.beije.ananke.service.OrderService;
import it.beije.ananke.service.ProductService;
import it.beije.ananke.service.UserService;

@RestController
@RequestMapping("/api")
public class ControllerREST {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private ProductService productService;
	
	
	//USER UTILITY CONTROLLER
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
			
		return "index";
	}
	
	@DeleteMapping(value = "/deleteUser/{id}")
	public boolean deleteUser(@PathVariable int id)
	{
		return userService.deleteById(id);
	}
	
	@GetMapping(value = "/utenti")
	public List<User> getUtenti()
	{
		return userService.findAll();
	}
	
	@RequestMapping(value="/register")
	public String register()
	{
		return "registration_form";
	}
	
	@PostMapping(value="/registerForm")
	public User registerForm(@RequestBody User user)
	{
		User utente = userService.findByEmail(user.getEmail());/*JPAmanager.findUserByEmail(user.getEmail());*/
		
		if(utente!=null)
		{
			return user;
		}
		else {
				userService.save(user);
				//JPAmanager.addUser(user);
			
				return user;
		}	
	}
	
	@RequestMapping(value="/login")
	public String login()
	{
		return "login_form";
	}
	
	@PostMapping(value="/loginForm")
	public User loginForm(@RequestBody User user, HttpSession session)
	{
		User utente = userService.findByEmail(user.getEmail());/*JPAmanager.findUserByEmail(email);*/
		
		if(utente!=null)
		{
			if(utente.getPassword().equals(user.getPassword()))
			{
				session.setAttribute("user", utente);
				
				return utente;
			}
			else return null;
		}
		else return null;		
	}
	
	//ORDER UTILITY CONTROLLER
	
	@GetMapping(value = "/products")
	public @ResponseBody List<Product> showProducts()
	{
		return productService.findAll();
	}
	
	@GetMapping(value ="/orderHistory/{id}")
	public  @ResponseBody List<Order> myOrders(@PathVariable int id)
	{	
		return orderService.findByUserId(id);/*JPAmanager.findOrderByUser(utente.getId());*/
	}
	
	@GetMapping(value = "/purchase/{id}")
	public @ResponseBody List<OrderItem>purchase(@PathVariable Integer id, HttpSession session, Model model )
	{
//		Product prod = productService.findById(id); /*JPAmanager.findProductById(id);*/
//		User user = (User) session.getAttribute("user");
//		Order order = (Order)session.getAttribute("order");
//		OrderItem ordIt = new OrderItem();
//		
//		if(order==null)
//		{
//		order = new Order();
//		order.setState("open");
//		order.setUserId(user.getId());
//		orderService.save(order);
//		session.setAttribute("order",order);
//		}
//		
//		ordIt = orderItemService.findByOrderIdAndProductId(order.getId(), id);
//		if(ordIt!=null)
//		{
//			ordIt.setQuantity(ordIt.getQuantity()+1);
//			ordIt.setAmount((ordIt.getQuantity())*(prod.getPrice()));
//			orderItemService.save(ordIt);
//			
//			
//		}
//		else
//		{
//			ordIt = new OrderItem();
//			ordIt.setOrderId(order.getId());
//			ordIt.setProductId(id);
//			ordIt.setQuantity(1);
//			ordIt.setAmount(prod.getPrice());
//			orderItemService.save(ordIt);
//			
//		}
		
		//List<OrderItem> items = orderItemService.findAllByOrderId(id);
		//model.addAttribute("items",items);
		//model.addAttribute("amount",orderItemService.totalAmount(order.getId()));
		 return orderItemService.findAllByOrderId(id); //"purchase_order";
	}
	
	@GetMapping(value="/continuaAcquisto")
	public String continuaAcquisto()
	{
		return "index";
	}
	
	@GetMapping(value="/confermaAcquisto")
	public String confemaAcquisto(HttpSession session)
	{
		Order order = (Order)session.getAttribute("order");
		
		Order ord = orderService.findById(order.getId());
				
		ord.setAmount(orderItemService.totalAmount(order.getId()));
		ord.setState("close");
		
		orderService.save(ord);
		
		session.setAttribute("order",null);
		
		return "confermato";
	}
	
	@GetMapping(value="/annullaOrdine")
	public String annullaOrdine(HttpSession session)
	{
		Order order = (Order) session.getAttribute("order");	
		
		order.setAmount(orderItemService.totalAmount(order.getId()));
		orderItemService.deleteByOrderId(order.getId());		
		orderService.updateStatus(order.getId());
		session.setAttribute("order",null);
		
		return "index";
	}
}
