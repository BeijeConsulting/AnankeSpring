package it.beije.ananke.ivo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ivo.model.Contatto;
import it.beije.ananke.ivo.repository.ContattoRepository;

@Controller
public class RubricaController {
	
	@Autowired
	private ContattoRepository contattoRepository;
	

	@GetMapping("/cerca")
	//@RequestMapping(value = "/cerca", method = RequestMethod.GET)
	public String cerca() {
		return "cerca";
	}

	@PostMapping("/cerca")
	//@RequestMapping(value = "/cerca", method = RequestMethod.POST)
	public String cerca(@RequestParam String email, Model model) {
		System.out.println("email : " + email);
		
		Contatto contatto = contattoRepository.findByEmail(email);
		System.out.println(contatto);
		
		model.addAttribute("contatto", contatto);
		
		return "datiContatto";
	}

}
