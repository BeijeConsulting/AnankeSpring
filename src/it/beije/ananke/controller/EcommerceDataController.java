package it.beije.ananke.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.Cart;
import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.UserRepository;
import it.beije.ananke.service.CartService;
import it.beije.ananke.service.UserService;
import it.beije.ananke.repository.ProductRepository;

@Controller
public class EcommerceDataController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductRepository pr;
	
	
	
	@RequestMapping(value = "/verifica", method = RequestMethod.POST)
	public String verificaLogin(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) {
		User user = userService.findByEmail(email);
		
		if(user == null) {
			model.addAttribute("missing", "Utente non registrato");
			return "home";
		}else {
			
			if(password.equals(user.getPasword())) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				model.addAttribute("errore", null);
				model.addAttribute("correct", null);
				model.addAttribute("list", pr.findAll());
				return "schermataProdotti";
			}else {
				model.addAttribute("errore", "Autenticazione fallita");
				return "login";
			}
		}
	}
	

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(@RequestParam String email, @RequestParam String password, @RequestParam String name_param , @RequestParam String surname_param, Model model) {
		User user = userService.signUp(email, password, name_param, surname_param);
		if(user == null) {
			model.addAttribute("errore", "Email già associata ad un account.");
			model.addAttribute("correct", null);
			return "signUp";
		}else {
			model.addAttribute("errore", null);
			model.addAttribute("correct", "La registrazione è avvenuta corretamente, esegui l'accesso");
			return "login";
		}
	}
	
	
	@RequestMapping(value = "/aggiungi", method = RequestMethod.POST)
	public String aggiungiCarrello(@RequestParam String productId, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = ((User) session.getAttribute("user")).getId() + "";
		Cart cart = cartService.addToCart(userId, productId);
		model.addAttribute("cart", cart);
		return "carrello";
	}
	
	
	@RequestMapping(value = "/mainShopping", method = RequestMethod.GET)
	public String backToShopping(Model model) {
		model.addAttribute("list", pr.findAll());
		return "schermataProdotti";
	}
	
	@RequestMapping(value = "/statoCarrello", method = RequestMethod.GET)
	public String statoCarrello(Model model, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		model.addAttribute("cart", cartService.showCart(user.getId() + ""));
		return "carrello";
	}
	
	@RequestMapping(value = "/rimuovi", method = RequestMethod.POST)
	public String rimuoviDaCarrello(Model model, HttpServletRequest request, @RequestParam String orderItemId) {
		User user = (User)request.getSession().getAttribute("user");
		model.addAttribute("cart", cartService.removeFromCart(user.getId() + "", orderItemId));
		return "carrello";
	}
	
}
