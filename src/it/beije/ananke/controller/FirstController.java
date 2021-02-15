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
import it.beije.ananke.model.User;

@Controller
public class FirstController {

	@RequestMapping(value = {"/", "index", "pippopluto"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model, Locale locale) {
		System.out.println("sono nella index..." + request.getRequestURL() + " - locale " + locale.getDisplayCountry());
		String saluto = "Buongiorno";
		model.addAttribute("saluto", saluto);
		return "LogUser";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		System.out.println("sono nella hello...");
		return "hello";
	}

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(Model model) {
		System.out.println("Vado nella JSP di test");
		model.addAttribute("test", "questo è un test di prova");
		return "test";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		System.out.println("get form...");
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

	@RequestMapping(value = "/RegistrazioneUser", method = RequestMethod.POST)
	public String registraUser(@RequestParam String first_name, @RequestParam String second_name,@RequestParam String email, @RequestParam String password,User u, Model model, HttpServletRequest request) {
		System.out.println("User da inserire : " + u);
		JPAmanager<?> j  = new JPAmanager<>();
		if(j.isValidEmail(email)) {
		j.inserimento(email, password, first_name, second_name);
		return "LogUser";
		}
		else {
			model.addAttribute("Errore", false);
			return "RegistrazioneUser";
		}
	}

	@RequestMapping(value = "/logUsers", method = RequestMethod.POST)
	public String LoginUser(Model model, HttpServletRequest request) {
		JPAmanager<?> j = new JPAmanager<>();
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		System.out.println("email = " + email);
		System.out.println("password = " + password);
		if(j.isRegister(email, password)) {
			User u = j.searchEmail(email);
			HttpSession session = request.getSession();
			session.setAttribute("Utente", u);
			return "Home";
		}
		else
			return "LogUser";
	}
	
	@RequestMapping(value = "/Reg", method = RequestMethod.POST)
	public String LoginUser(HttpServletRequest request, Model model) {
		model.addAttribute("Errore", true);
		return "RegistrazioneUser";
	}
	
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String AccessoUser(HttpServletRequest request) {
		return "LogUser";
	}
	
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public String acquista(HttpServletRequest request, User u, Model model) {
//		JPAmanager<?> j = new JPAmanager<>();
//		ArrayList<Product> p = (ArrayList<Product>) j.getList("Product");
//		for (Product product : p) {
//			model.addAttribute("ListaProdotti", p);
//		}
//		model.addAttribute("ListaProdotti", p);
		return "Prodotti";
	}
	
	@RequestMapping(value = "/mod", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request) {
		return "updateUser";
	}
	
	@RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
	public String update(HttpSession session, @RequestParam String first_name, @RequestParam String second_name,@RequestParam String password, HttpServletRequest request) {
		JPAmanager<?> j = new JPAmanager<>();
		User u;
		u= (User) session.getAttribute("Utente");
		j.update(first_name, second_name, password, u.getEmail());
		return "Home";
	}
	@RequestMapping(value = "/annullaUpdate", method = RequestMethod.POST)
	public String noUpdate(HttpServletRequest request) {
		return "Home";
	}
}
