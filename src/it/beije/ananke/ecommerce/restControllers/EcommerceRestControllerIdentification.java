package it.beije.ananke.ecommerce.restControllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.EcommerceException;
import it.beije.ananke.ecommerce.beans.Cart;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.services.EcommerceServiceUser;

@RestController
@RequestMapping("/api")
public class EcommerceRestControllerIdentification{

	@Autowired
	private EcommerceServiceUser serviceUser;
	
	@GetMapping("/ecommerce/infoUser/{userId}")
	public User getInfoUser(@PathVariable Integer userId){
		
		User user = serviceUser.findById(userId);
		
		return user;
		
	}
	
	@PostMapping("/ecommerce/registration")
	public User postRegistration(@RequestBody User user){
		
		if((user.getEmail().length() != 0) && (user.getPassword().length() != 0)) {
			try {
				user = serviceUser.save(user);
			} catch (EcommerceException e) {
				System.out.println("C'è stato un problema nel registrare l'utente");
			}
		}
		//TODO: aggiungere messaggi nel caso di email o pw vuota
		//		aspe... ma ho fatto il form figo che non ti fa andare avanti se non li metti. top
		
		return user;
		
	}
	
	@PostMapping("/ecommerce/logIn")
	public User postLogIn(@RequestBody User user){
	
		user = serviceUser.findByEmail(user.getEmail());
		
		return user;
		
	}

}
