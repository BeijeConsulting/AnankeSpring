package ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ecommerce.entity.Product;
import ecommerce.entity.User;
import ecommerce.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
private ProductRepository product_rep;


public String addProduct (String name, String desc, Double price) {
	Product p = new Product();
	p.setDesc(desc);
	p.setName(name);
	if(price <0) {
		return "Attenzione, errore nell'aggiunta del prodotto.";
	}	
	p.setPrice(price);
	product_rep.save(p);
	return "Il prodotto è stato aggiunto correttamente.";
}


public List<Product> findAll(){
	return product_rep.findAll();
}



public Product getOne(Integer id) {
	return product_rep.getOne(id);
}

public void delete(Product p) {
	product_rep.delete(p);
}

}
