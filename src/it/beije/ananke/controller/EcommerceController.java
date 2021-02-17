package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.*;



@Controller
public class EcommerceController {

	
	
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model, Locale locale) {
		return "index1";
	}
	@RequestMapping(value = {"logout"}, method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model, Locale locale, HttpSession session) {
	session.invalidate();
		return "index1";
	}
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, Locale locale) {
		HttpSession session=request.getSession();
		boolean succes=	JPAManager.passwordCorretta(request.getParameter("email"),request.getParameter("password"));
			 if(succes) {
				Users users= JPAManager.returnUser(request.getParameter("email"));
			session.setAttribute("users", users);
			session.setAttribute("login", "ok");
			session.setAttribute("session", true);
			}else {
				session.setAttribute("login", "error");
			 session.setAttribute("session", false);
			}
			 
			 return "index1";

			}
	
	@RequestMapping(value = {"/prodotto"}, method = RequestMethod.GET)
	public String prodotto(HttpServletRequest request, Model model, Locale locale) {
		Product prodotto= JPAManager.returnProduct(request.getParameter("id"));
		HttpSession session=request.getSession();
		session.setAttribute("prodotto", prodotto);
		return "prodotto";
			}
	
	
	@RequestMapping(value = {"/registrazione"}, method = RequestMethod.GET)
	public String registrazione(HttpServletRequest request, Model model, Locale locale) {
	
		return "registrazione";

			}
	
	@RequestMapping(value = {"/registrazione"}, method = RequestMethod.POST)
	public String registrazione(HttpServletRequest request, Model model, HttpSession session) {
		boolean successo=JPAManager.addUser(request.getParameter("email"),request.getParameter("name"), request.getParameter("surname"),request.getParameter("password"));
		if(successo)
		return "index";
		else {
			session.setAttribute("registrazione", false);
		return "registrazione";

			}
		
	}
	@RequestMapping(value = {"/carrello"}, method = RequestMethod.POST)
	public String carrello(HttpServletRequest request, Model model, Locale locale, HttpSession session) {
		Users utente=(Users)session.getAttribute("users");
		boolean confermato=JPAManager.addOrderItem(utente.getId(),(String)request.getParameter("id"),(String)request.getParameter("quan") );
		if(confermato) {
			List<OrderItem> carrello= JPAManager.ritornoCarrello(utente.getId());
			model.addAttribute("carrello", carrello);
			for(OrderItem x : carrello)
				System.out.println(x.getId());
//			session.setAttribute("carrello", carrello);
			return "carrello"; 
		}
		else {
			model.addAttribute("errorAcquisto", "ERRORE");	
			return "prodotto";
		}


			}
	
//	@RequestMapping(value = {"/carrello"}, method = RequestMethod.GET)
//	public String carrello(HttpServletRequest request, Model model, HttpSession session) {
//		Users utente=(Users)session.getAttribute("users");
//			ArrayList<OrderItem> carrello= JPAManager.ritornoCarrello(utente.getId());
//			model.addAttribute("carrello", carrello);
//			session.setAttribute("carrello", carrello);
//			return "carrello"; 
//		
//	}
	

	@PostMapping("/acquista")
	public String acquista(@RequestParam int idOrdine, Model model ,HttpSession session ) {
		JPAManager.changeStateOrder(idOrdine,"CLOSE");
		Users utente=(Users)session.getAttribute("users");
		ArrayList<Order> ordini=JPAManager.listaOrdiniUtente(utente.getId());
		model.addAttribute("ordini", ordini);
		return "ordini";
	}
			
	
	
}
	
	
	
	

