package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FirstController {

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String getString(HttpServletRequest request, Model model, Locale locale) {
		System.out.println("getString method called...");
		List <String> list = new ArrayList<>();
		  list.add("abc");
		  list.add("xyz");
		  
			  model.addAttribute("list", list);
		  
		return "getString";
	}
	
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
	
	@RequestMapping(value = {"/postContact"}, method = RequestMethod.POST)
	public String setString(@RequestParam String nome, @RequestParam String cognome , Model model) {
		model.addAttribute("nome", nome);
		model.addAttribute("cognome", cognome);
		
		return null;
	}
}
