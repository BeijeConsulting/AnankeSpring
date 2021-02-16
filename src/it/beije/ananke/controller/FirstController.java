package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import it.beije.ananke.model.JPAmanager;
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
		JPAmanager<?> jpa = new JPAmanager<>();
		@SuppressWarnings("unchecked")
		ArrayList<Product> list = (ArrayList<Product>)jpa.getList("Product");
		model.addAttribute("listaprodotti", list);
		return "ListaProdotti";
	}
	
	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public String sign(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
		User s = service.findByEmail(email);
		if(!(s.getEmail().equals(null)) && s.getPassword().equals(password)) {
			    session.setAttribute("utente", s);
				model.addAttribute("visible", "block");
				return "Home";
		}
		model.addAttribute("error", true);
     	return "Log";
	}
	
	@RequestMapping(value = "/preleva/{id}", method = RequestMethod.GET)
	public String preleva(@PathVariable Integer id, Model model) {
		JPAmanager<?> jpa = new JPAmanager<>();
		@SuppressWarnings("unchecked")
		ArrayList<Product> list = (ArrayList<Product>)jpa.getList("Product");
		for(Product p : list ) {
			if(p.getId() == id) {
				System.out.println("elemento trovato");
				model.addAttribute("el", p);
				return "acquistaProdotto";
			}
		}
		return null;
	}
	
	
	@RequestMapping(value = "/lista1", method = RequestMethod.GET)
	public String Lista() {
		
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
	
	
	@RequestMapping(value = "/modificauser", method = RequestMethod.GET)
	public String modificauser(HttpServletRequest request, Model model, Locale locale) {
		model.addAttribute("visible", "block");
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
	@RequestMapping(value = "/addorder {id}", method = RequestMethod.GET)
	public String addorder(Model model, @RequestParam String numero, @PathVariable Integer id, HttpSession session) {
		System.out.println(id +  " "  + Integer.valueOf(numero));
		JPAmanager<?> jpa = new JPAmanager<>();
		User s = (User) session.getAttribute("utente");
		jpa.inOrder(s.getId(), id, Integer.valueOf(numero));
		
		ArrayList<Order_items> lista = (ArrayList<Order_items>) jpa.getList("Order_items");
		
		model.addAttribute("ordine", lista );
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
		
		//String nome = request.getParameter("nome");
		//String cognome = request.getParameter("cognome");
		
		model.addAttribute("nome", nome);
		model.addAttribute("cognome", cognome);
		
		return "dati";
	}

	@RequestMapping(value = "/contatto/{id}", method = RequestMethod.GET)
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

}
