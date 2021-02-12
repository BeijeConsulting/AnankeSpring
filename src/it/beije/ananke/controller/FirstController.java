package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.Contatto;
import it.beije.ananke.model.JPAmanager;
import it.beije.ananke.model.Product;



@Controller
public class FirstController {
	
	
	@RequestMapping(value = {"/", "home", "pippopluto"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model, Locale locale) {
		return "Home";
	}
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.GET)
	public String Reg(HttpServletRequest request, Model model, Locale locale) {
		return "Registrazione";
	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String Lista(HttpServletRequest request, Model model, Locale locale) {
		JPAmanager<?> jpa = new JPAmanager();
		ArrayList<Product> list = (ArrayList<Product>)jpa.getList("Product");
		model.addAttribute("listaprodotti", list);
		return "ListaProdotti";
	}
	

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public void check(HttpServletRequest request, Model model, Locale locale) {
		System.out.println(request.getParameter("id"));
	}
	
	
	@RequestMapping(value = "/lista1", method = RequestMethod.GET)
	public String Lista() {
		
		return "ListaProdotti";
	}
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public String log(HttpServletRequest request, Model model, Locale locale) {
		return "Log";
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
	
	
	@RequestMapping(value = "/contatto", method = RequestMethod.POST)
	public String postContatto(Contatto c, Model model) {
		System.out.println("postContatto : " + c);
		
		model.addAttribute("contatto", c);
		
		return "datiContatto";
	}

}
