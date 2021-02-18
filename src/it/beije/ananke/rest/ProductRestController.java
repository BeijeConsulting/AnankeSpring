package it.beije.ananke.rest;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.model.Product;
import it.beije.ananke.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public Product getProduct(@PathVariable Integer id) {
		System.out.println("api get method called....");
		Product product = productService.getProduct(id);
		return product;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insertProduct(@RequestBody Product product) {
		System.out.println("post method called.....");
		productService.save(product);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable Integer id) {
		System.out.println("delete method called.....");
		productService.deleteById(id);
	}
	
	@RequestMapping(value="/update/{id}" , method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable Integer id, @RequestBody Product productFromClient) {
		System.out.println("put method is called!");
		
		Product temp = productService.getProduct(productFromClient.getId());
		if (id.compareTo(productFromClient.getId()) != 0){
			throw new RuntimeException("two ids are not the same");
		}
		
		  if(temp!=null) { //means this product exists in DB and can be updated
			   if(productFromClient.getProductName()!=null) {
				   temp.setProductName(productFromClient.getProductName());
			   }
			   if(productFromClient.getProductDescription()!=null) {
				   temp.setProductDescription(productFromClient.getProductDescription());
			   }
			   if(productFromClient.getPrice()!=0) {
				   temp.setPrice(productFromClient.getPrice());
			   }
			   
			   productService.save(temp);
			   return temp;
			   
		  }
		  else throw new RuntimeException("No such product exists in DB to update");
		
	}
	

}
