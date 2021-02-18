package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

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

import it.beije.ananke.model.Contatto;
import it.beije.ananke.model.JPAmanager;
import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.ContattoRepository;

import it.beije.ananke.repository.ProductRepository;
import it.beije.ananke.repository.UserRepository;
import it.beije.ananke.service.ProductService;
import it.beije.ananke.service.RubricaService;
import it.beije.ananke.service.UtenteService;


@Controller
public class FirstController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ContattoRepository contattoRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private ProductService productService;


	@RequestMapping(value = {"/", "index", "pippopluto"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model, Locale locale) {
		System.out.println("sono nella index..." + request.getRequestURL() + " - locale " + locale.getDisplayCountry());
		String saluto = "Buongiorno";
		model.addAttribute("saluto", saluto);
		return "LogUser";
	}

//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
//	public String hello() {
//		System.out.println("sono nella hello...");
//		return "hello";
//	}

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(Model model) {
		System.out.println("Vado nella JSP di test");
		model.addAttribute("test", "questo è un test di prova");
		return "test";
	}

//	@RequestMapping(value = "/form", method = RequestMethod.GET)
//	public String form() {
//		System.out.println("get form...");
//		return "form";
//	}

//	@RequestMapping(value = "/form", method = RequestMethod.POST)
//	public String form(@RequestParam(required = false) String nome, @RequestParam String cognome, HttpServletRequest request, Model model) {
//		System.out.println("post form...");
//
//		//String nome = request.getParameter("nome");
//		//String cognome = request.getParameter("cognome");
//
//		model.addAttribute("nome", nome);
//		model.addAttribute("cognome", cognome);
//
//		return "dati";
//	}

//	@RequestMapping(value = "/contatto/{id}", method = RequestMethod.GET)
//	public String getContatto(@PathVariable Integer id, Model model) {
//		System.out.println("getContatto id : " + id);
//
//		//... SELECT * from Contatto where id = {id}
//
//		model.addAttribute("nome", "Pippo");
//		model.addAttribute("cognome", "Pluto");
//
//		return "dati";
//	}

//	@RequestMapping(value = "/contatto", method = RequestMethod.GET)//contatto?id=5
//	public String getContatto(@RequestParam int id, Model model) {
//		System.out.println("getContatto id parametro : " + id);
//
//		//... SELECT * from Contatto where id = {id}
//
//		model.addAttribute("nome", "Pippo");
//		model.addAttribute("cognome", "Pluto");
//
//		return "dati";
//	}

	//	@RequestMapping(value = "/contatto", method = RequestMethod.POST)
	//	public String postContatto(Contatto c, Model model) {
	//		System.out.println("postContatto : " + c);
	//		
	//
	//		contattoRepository.save(c);
	//
	//		try {
	//			rubricaService.checkAndSave(c);
	//			
	//		} catch (Exception e) {
	//			model.addAttribute("errore", e.getMessage());
	//			return "dati"; 
	//		}
	//
	//
	//		model.addAttribute("contatto", c);
	//
	//		return "datiContatto";
	//
	//	}

	@RequestMapping(value = "/RegistrazioneUser", method = RequestMethod.POST)
	public String registraUser(@RequestParam String first_name, @RequestParam String second_name,@RequestParam String email, @RequestParam String password,Model model, HttpServletRequest request) {
		User u = utenteService.insertUser(email, password, first_name, second_name);
		if(u!=null) {
			return "LogUser";
		}
		else {
			model.addAttribute("Errore", false);
			return "RegistrazioneUser";
		}
	}

	@RequestMapping(value = "/logUsers", method = RequestMethod.POST)
	public String LoginUser(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) {
		User u = utenteService.findByEmailAndPassword(email, password);
		if (u!=null) {
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
		model.addAttribute("listaProdotti", utenteService.searchProducts());
		return "Prodotti";
	}

	@RequestMapping(value = "/mod", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request) {
		return "updateUser";
	}

	@RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
	public String update(HttpSession session, @RequestParam String first_name, @RequestParam String second_name,@RequestParam String password, HttpServletRequest request) {
	utenteService.updateUser(password, password, first_name, second_name, session);
		return "Home";
	}
	@RequestMapping(value = "/annullaUpdate", method = RequestMethod.POST)
	public String noUpdate(HttpServletRequest request) {
		return "Home";
	}
	
	@RequestMapping(value = "/prodottoSpec {id}", method = RequestMethod.POST)
	public String imagesiD(HttpServletRequest request, Model model, @PathVariable Integer id) {
		Product p = productService.findById(id);
		model.addAttribute("immagine", p);
		return "image";
	}
	
	@RequestMapping(value = "/out", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "LogUser";
	}
	@RequestMapping(value = "/acq {id}", method = RequestMethod.POST)
	public String compra(HttpServletRequest request, HttpSession session, @PathVariable Integer id,@RequestParam int quantita) {		
		productService.buyProduct(id, quantita);
		return "Home";
	}
	
}