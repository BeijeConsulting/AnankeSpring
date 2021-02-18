//package it.beije.ananke.controller;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import it.beije.ananke.dto.Message;
//import it.beije.ananke.model.Contatto;
//import it.beije.ananke.repository.ContattoRepository;
//import it.beije.ananke.service.RubricaService;
//
//
////@Controller
//@RestController
//@RequestMapping("/api")
//public class MyRestController {
//	
//	@Autowired
//	RubricaService rubricaService;
//
//	@Autowired
//	private ContattoRepository contattoRepository;
//
//	
////	@RequestMapping(value = "/contatto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // /api/contatto/{id}
////	public @ResponseBody Contatto getContatto(@PathVariable Integer id) {
//	@GetMapping("/contatto/{id}") // /api/contatto/{id}
//	public Contatto getContatto(@PathVariable Integer id) {
//		System.out.println("api getContatto id : " + id);
//		
//		Contatto c = contattoRepository.findById(id).get();
//		System.out.println(c);
//		System.out.println("DataNascita : " + c.getDataNascitaAsString());
//		
//		LocalDate dataNascita = c.getDataNascita();
//		
//		return c;		
//	}
//	
//	
////	@RequestMapping(value = "/contatto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@PostMapping("/contatto")
//	public Contatto insertContatto(@RequestBody Contatto contatto) {
//		System.out.println("api insertContatto contatto : " + contatto);
//		System.out.println("DataNascita : " + contatto.getDataNascitaAsString());
//		
//		contattoRepository.save(contatto);		
//		
//		return contatto;
//	}
//
//	@PutMapping("/contatto/{id}")
//	public Contatto updateContatto(@PathVariable Integer id, @RequestBody Contatto contatto) {
//		System.out.println("api updateContatto id : " + id);
//		System.out.println("api updateContatto contatto.id : " + contatto.getId());
//		
//		//if (id.intValue() == contatto.getId().intValue()) {
//		if (id.compareTo(contatto.getId()) == 0) {
//			System.out.println("ID coerenti");
//			
//			Optional<Contatto> optC = contattoRepository.findById(id);
//			System.out.println("optC isPresent ? " + optC.isPresent());
//			if (optC.isPresent()) {
//				Contatto c = optC.get();
//				
//				if (contatto.getName() != null) c.setName(contatto.getName());
//				if (contatto.getSurname() != null) c.setSurname(contatto.getSurname());
//				if (contatto.getEmail() != null) c.setEmail(contatto.getEmail());
//
//				return contattoRepository.save(c);
//
//			} else throw new IllegalArgumentException("ID contatto non trovato");
//			
//		} else throw new IllegalArgumentException("IDs non coerenti");
//	}
//	
//	@DeleteMapping("/contatto/{id}")
//	public Message deleteContatto(@PathVariable Integer id) {
//		System.out.println("api updateContatto id : " + id);
//		
//		//rimuovo su DB
////		contattoRepository.deleteById(id);
//		
//		//rimuovo a livello FUNZIONALE ma conservo valore su DB
//		Optional<Contatto> optC = contattoRepository.findById(id);
//		System.out.println("optC isPresent ? " + optC.isPresent());
//		if (optC.isPresent()) {
//			Contatto c = optC.get();
//
//			//c.setDisable(true);
//			c.setEmail(null);
//
//			contattoRepository.save(c);
//			
////			Map<String, String> esito = new HashMap<String, String>();
////			esito.put("deleted", "true"); 
//			return new Message("contatto rimosso");	
//
//		} else throw new IllegalArgumentException("ID contatto non trovato");		
//
//	}
//
//}
//
//
//
//
