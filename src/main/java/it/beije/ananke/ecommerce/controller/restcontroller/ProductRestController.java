package it.beije.ananke.ecommerce.controller.restcontroller;

import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable Integer productId) {
        Product p = productRepository.findById(productId).get();
        return p;
    }

    @PostMapping("/newproduct")
    public Product newProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/modifyproduct/{productId}")
    public Product modifyProduct(@PathVariable Integer productId, @RequestBody Product product) {
        if ((productId.compareTo(product.getId()) == 0)) {
            System.out.println("You can modify product");
            Product p = productRepository.findById(productId).get();
            if (p != null) {
                if (product.getPrice() != null) {
                    p.setPrice(product.getPrice());
                } else {
                    p.setPrice(p.getPrice());
                }

                if (product.getName() != null) {
                    p.setName(product.getName());
                } else {
                    p.setName(p.getName());
                }

                if(product.getDescription()!=null) {
                    p.setDescription(product.getDescription());
                } else {
                    p.setDescription(p.getDescription());
                }

                return productRepository.save(p);
            } else {
                throw new IllegalArgumentException("No such product exception");
            }
        } else {
            throw new IllegalArgumentException("Incoherent ids");
        }
    }
}
