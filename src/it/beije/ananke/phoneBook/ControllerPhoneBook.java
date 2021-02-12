package it.beije.ananke.phoneBook;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerPhoneBook {
	
	@RequestMapping(value = {"/rubrica"}, method = RequestMethod.GET) 
	public String index(HttpServletRequest request, Model model, Locale locale) {
		
		//visualizzo la pagina iniziale con il form dei tasti che mi indirizzano alle varie operazioni
		
		return "indice"; 
	}

}
