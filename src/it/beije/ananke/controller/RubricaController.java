//package it.beije.ananke.controller;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import it.beije.ananke.model.Contatto;
//import it.beije.ananke.repository.ContattoRepository;
//import it.beije.ananke.service.RubricaService;
//
//@Controller
//public class RubricaController {
//	
//	@Autowired
//	private RubricaService rubricaService;
//	
//
//	@GetMapping("/cerca")
//	//@RequestMapping(value = "/cerca", method = RequestMethod.GET)
//	public String cerca() {
//		return "cerca";
//	}
//
//	@PostMapping("/cerca")
//	//@RequestMapping(value = "/cerca", method = RequestMethod.POST)
//	public String cerca(@RequestParam String email, Model model) {
//		System.out.println("email : " + email);
//		
//		Contatto contatto = rubricaService.findByEmail(email);
//		System.out.println(contatto);
//		
//		model.addAttribute("contatto", contatto);
//		
//		return "datiContatto";
//	}
//
//	@PostMapping("/cercaPerCognome")
//	public String cercaPerCognome(@RequestParam String surname, Model model) {
//		System.out.println("surname : " + surname);
//		
//		List<Contatto> contatti = rubricaService.searchByFirstLettersOfSurname(surname);
//		System.out.println(contatti.size());
//		for (Contatto c : contatti) {
//			System.out.println(c);
//			
//			model.addAttribute("contatto", c);
//		}
//		
//		return "datiContatto";
//	}
//
//}
