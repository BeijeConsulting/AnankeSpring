package ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import ecommerce.entity.*;
import ecommerce.services.Order_ItemService;
import ecommerce.services.ProductService;


@RestController
@RequestMapping("/api")
public class ProductRestController {
@Autowired
private Order_ItemService orderItem_service;
@Autowired
private ProductService product_service;


@GetMapping("getItem")
public List<Order_Item> getItems(@RequestParam Integer id){
	return orderItem_service.findAllById(id);
}

@GetMapping("/getProduct")
public List<Product> getProduct() {
	return product_service.findAll();
}

@PostMapping("/addProduct")
public Product addProduct(@RequestBody Product product) {
	product_service.addProduct(product);
	return product;
}
}
