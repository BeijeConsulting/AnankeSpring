//package it.beije.ananke.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import it.beije.ananke.dto.Message;
//import it.beije.ananke.model.Product;
//import it.beije.ananke.model.User;
//import it.beije.ananke.repository.ProductRepository;
//import it.beije.ananke.repository.UserRepository;
//import it.beije.ananke.service.ServiceRepository;
//
//@Controller
//@RestController
//@RequestMapping("/api")
//public class Controllerbit {
//
//	@Autowired
//	ServiceRepository service;
//	@Autowired
//	UserRepository userservice;
//	
//	//@RequestMapping(value = "/lista1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@GetMapping("/lista1")
//	public List<Product> Lista() {
//		return service.getlistaProdotti(); 
//		}
//	
//
//	@PostMapping("/inserimentoUtente")
//	public String insertUser(@RequestBody User user) {
//		if(service.findByEmail(user.getEmail()) == null) {
//		userservice.save(user);
//		Message.setMessage("Utente inserito");
//		return Message.getMessage();
//		}
//		Message.setMessage("Email già inserita");
//		return Message.getMessage();
//}
//	
//	
////	@PutMapping("/modificauser/{id}")
////	public String updateUser(@PathVariable Integer id, @RequestBody User user){
////		if(id == user.getId()) {
////		if(user.getFirst_name() == null || user.getSecond_name() == null || user.getPassword() == null) {
////			Message.setMessage("Utente non modificato, riempire tutte le credenziali");
////			return Message.getMessage();
////		}
////	    service.modifyProfile(user);
////		Message.setMessage("Utente modificato");
////		return Message.getMessage();
////		
////		}else {
////			Message.setMessage("Id non corretto");
////			return Message.getMessage(); 
////		}
////	
////	}
//	
//	@PutMapping("/modificauser/{id}")
//    public User updateProdotto(@PathVariable int id, @RequestBody  User user) {
//        System.out.println("api updateProdotto id : " + id);
//
//        if (id == user.getId()) {
//
//            Optional<User> tempProduct = userservice.findById(id);
//
//            if(tempProduct.isPresent()) {
//                User u = tempProduct.get();
//
//                if (user.getFirst_name() != null) u.setFirst_name(user.getFirst_name());
//                if (user.getSecond_name() != null) u.setSecond_name(user.getSecond_name());
//                if (user.getPassword() != null) u.setPassword(user.getPassword());
//
//                return userservice.save(u);
//
//            } else throw new IllegalArgumentException("ID prodotto non trovato");
//
//        }else throw new IllegalArgumentException("ID non coerenti");
//
//    }
//	
//	@DeleteMapping("/delete/{id}")
//	public String deleteContatto(@PathVariable Integer id) {
//		
//	//rimuovo su DB
//	//userservice.deleteById(id);
//		
//	//rimuovo a livello FUNZIONALE ma conservo valore su DB
//	Optional<User> optC = userservice.findById(id);
//	System.out.println("optC isPresent ? " + optC.isPresent());
//		if (optC.isPresent()) {
//			User c = optC.get();
//			//c.setDisable(true);
//			String email = String.valueOf(c.getId());
//			c.setEmail(email);
//			userservice.save(c);
//          Message.setMessage("Eliminato");
//		return Message.getMessage() ;	
//
//		} else Message.setMessage("Non eliminato");
//		return Message.getMessage();			
//
//	}
//}
