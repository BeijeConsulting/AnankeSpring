package it.beije.ananke.ecommerce.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.beans.Orders;
import it.beije.ananke.ecommerce.beans.Product;
import it.beije.ananke.ecommerce.services.EcommerceServiceOrder;
import it.beije.ananke.ecommerce.services.EcommerceServiceProduct;

@RestController
@RequestMapping("/api")
public class EcommerceRestController {

	@Autowired
	private EcommerceServiceProduct serviceProduct;

	@GetMapping("/ecommerce/products")
	public List<Product> getProducts() {
		
		List<Product> products = serviceProduct.findAll();
		
		//model.addAttribute("orders", userOrders);
		
		return products;
	}
	
}
