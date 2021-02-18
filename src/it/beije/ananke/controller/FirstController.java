package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import it.beije.ananke.model.JPAmanager;
import it.beije.ananke.model.Order;
import it.beije.ananke.model.Order_items;
import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.UserRepository;
import it.beije.ananke.service.ServiceRepository;


@Controller
public class FirstController {
	
	@Autowired
	private ServiceRepository service;


	
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("visible", "none");
		return "Home";
	}
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.GET)
	public String Reg(HttpServletRequest request, Model model, Locale locale) {
		return "Registrazione";
	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String Lista(HttpServletRequest request, Model model, Locale locale) {
		ArrayList<Product> list = (ArrayList<Product>)service.getlistaProdotti();
		model.addAttribute("listaprodotti", list);
		return "ListaProdotti";
	}
	
	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public String sign(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
		User s = service.findByEmail(email);
		if(!(s.getEmail().equals(null)) && s.getPassword().equals(password)) {
			    session.setAttribute("utente", s);
				model.addAttribute("visible", "block");
				model.addAttribute("visibilita", "none");
				model.addAttribute("nome", "Home page di " + s.getFirst_name());
				return "Home";
		}
		model.addAttribute("error", true);
     	return "Log";
	}
	
	@RequestMapping(value = "/preleva {id}", method = RequestMethod.POST)
	public String preleva(@PathVariable Integer id, Model model) {
		Product p = service.searchProduct(id);
		model.addAttribute("el", p);
     	return "acquistaProdotto";
		
	}
	
	
	@RequestMapping(value = "/lista1", method = RequestMethod.GET)
	public String Lista(Model model, HttpSession session) {
		model.addAttribute("list", service.getlistaProdotti());
		return "ListaProdotti";
	}
	
	@RequestMapping(value = "/out", method = RequestMethod.GET)
	public String out(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("visible", "none");
		return "Home";
	}
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public String log(HttpServletRequest request, Model model, Locale locale) {
		return "Log";
	}
	@RequestMapping(value = "/deleteitems {id}", method = RequestMethod.GET)
	public String deleteItems(Model model, HttpSession session, @PathVariable Integer id) {
		User user = (User)session.getAttribute("utente");
		Order or = service.getOrder(user.getId());
		service.deleteFromcart(id, session);
		model.addAttribute("listacarrello", service.getItemsCart(or));
		return "Cart";
	}
	@RequestMapping(value = "/viewcart", method = RequestMethod.GET)
	public String viewcart(Model model, HttpSession session) {
		User user = (User)session.getAttribute("utente");
		Order or = service.getOrder(user.getId());
		model.addAttribute("listacarrello", service.getItemsCart(or));
		return "Cart";
	}
	@RequestMapping(value = "/pagemodifca", method = RequestMethod.GET)
	public String modificauser() {
		return "ModificaProfilo";
	}
	@RequestMapping(value = "/modificauser", method = RequestMethod.GET)
	public String modificauser(@RequestParam String first_name, @RequestParam String second_name, @RequestParam String password, Model model, HttpSession session) {
		User user = (User) session.getAttribute("utente");
		user.setFirst_name(first_name);
		user.setSecond_name(second_name);
		user.setPassword(password);
	    service.modifyProfile(user);
		model.addAttribute("visible", "block");
		model.addAttribute("nome", "Home page di " + user.getFirst_name());
		return "Home";
	}
	
	@RequestMapping(value = "/inserimentoUtente", method = RequestMethod.POST)
	public String insertUtente(HttpServletRequest request, Model model,@RequestParam String email, @RequestParam String password, @RequestParam String first_name, @RequestParam String second_name) {
		if(service.findByEmail(email)== null) {
			User s = new User();
			s.setEmail(email);
			s.setFirst_name(first_name);
			s.setPassword(password);
			s.setSecond_name(second_name);
			service.save(s);
			return "Log";
			
		} else {
			model.addAttribute("error", "utente già registrato!");
			return "Registrazione";
		}
		
	}
	@RequestMapping(value = "/addorder {id}", method = RequestMethod.POST)
	public String addorder(Model model, @RequestParam String numero, @PathVariable Integer id, HttpSession session) {
		System.out.println(id +  " "  + Integer.valueOf(numero));
		service.saveorderitems(session, Integer.valueOf(numero), id);
		model.addAttribute("list", service.getlistaProdotti());
		
		return "ListaProdotti";
	}
	
	@RequestMapping(value = { "index", "pippopluto"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model, Locale locale) {
		System.out.println("sono nella index..." + request.getRequestURL() + " - locale " + locale.getDisplayCountry());
		
		String saluto = "Buongiorno";
		model.addAttribute("saluto", saluto);
		
		return "index";
	}
	
	@RequestMapping(value = { "/hello"}, method = RequestMethod.GET)
	public String hello() {
		System.out.println("sono nella hello...");
		return "hello";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String Test(Model model) {
		System.out.println("sono in test");
		String saluto = "We";
		model.addAttribute("saluto", saluto );
		return "test";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(HttpServletRequest request, Model model, Locale locale) {
		 String password = request.getParameter("password");
	        String email = request.getParameter("email");
	        String first_name = request.getParameter("first_name");
	        String second_name = request.getParameter("second_name");
	        System.out.println("email = " + email);
	        System.out.println("password = " + password);
	        System.out.println("nome = " + first_name);
	        System.out.println("cognome = " + second_name);
	        JPAmanager<?> j = new JPAmanager<>();
	        j.inserimento(email, password, first_name, second_name);
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String form(@RequestParam(required = false) String nome, @RequestParam String cognome, HttpServletRequest request, Model model) {
		System.out.println("post form...");

		model.addAttribute("nome", nome);
		model.addAttribute("cognome", cognome);
		
		return "dati";
	}

	@RequestMapping(value = "/contatto/{id}", method = RequestMethod.POST)
	public String getContatto(@PathVariable Integer id, Model model) {
		System.out.println("getContatto id : " + id);
		
		//... SELECT * from Contatto where id = {id}
		
		model.addAttribute("nome", "Pippo");
		model.addAttribute("cognome", "Pluto");
		
		return "dati";
	}

	@RequestMapping(value = "/contatto", method = RequestMethod.GET)//contatto?id=5
	public String getContatto(@RequestParam int id, Model model) {
		System.out.println("getContatto id parametro : " + id);
		
		//... SELECT * from Contatto where id = {id}
		
		model.addAttribute("nome", "Pippo");
		model.addAttribute("cognome", "Pluto");
		
		return "dati";
	}
	
	

	
//	
//	@RequestMapping(value = "/contatto", method = RequestMethod.POST)
//	public String postContatto(Contatto c, Model model) {
//		System.out.println("postContatto : " + c);
//		
//		contattoRepository.save(c);
//		
//		model.addAttribute("contatto", c);
//		
//		return "datiContatto";
//	}

//	@RequestMapping(value = "/contatto", method = RequestMethod.POST)
//	public String postContatto(Contatto c, Model model) {
//		System.out.println("postContatto : " + c);
//		
//		try {
//			rubricaService.checkAndSave(c);
//			
//		} catch (Exception e) {
//			model.addAttribute("errore", e.getMessage());
//			return "dati"; 
//		}
//
//		model.addAttribute("contatto", c);
//		
//		return "datiContatto"; 
//	}


}
