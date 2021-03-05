package it.beije.ananke.ecommerce.restControllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.EcommerceException;
import it.beije.ananke.ecommerce.beans.Product;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.dto.HomeMessage;
import it.beije.ananke.ecommerce.dto.LogInMessage;
import it.beije.ananke.ecommerce.services.EcommerceServiceUser;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
				System.out.println("C'� stato un problema nel registrare l'utente");
			}
		}
		
		return user;
		
	}
	
	@PostMapping("/ecommerce/logIn")
	public User postLogIn(@RequestBody User user, HttpSession session){
	
		User userDB = serviceUser.findByEmail(user.getEmail());
		//LogInMessage message = new LogInMessage();
		
		if(userDB != null) {
			//user registrato
			if(user.getPassword().equals(userDB.getPassword())) {
				
				//per agevolare i controller mettiamo comunque le cose nella sessionHTTP
				session.setAttribute("user", userDB);
//				message.setUser(userDB);
//				message.setMessage("logged");
//				return message;
				
				return userDB;
				
			}
			else {
				
//				message.setUser(null);
//				message.setMessage("UnPw");
//				return message;
				return null;
			}
			
		}
		
//		message.setUser(null);
//		message.setMessage("UnEmail");
//		return message;
		
		return null;
		
	}
	
	@PostMapping("/ecommerce/homePage")
	public HomeMessage getInfoHome(HttpSession session) {
		
		HomeMessage message = new HomeMessage();
		List<Product> products = getProducts();
		
		message.setProducts(products);
		message.setMessage("welcome");
		
		return message;
		
	}

}
