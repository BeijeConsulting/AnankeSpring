package it.beije.ananke.ecommerce.restcontroller;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.OrderItemRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OrderRestController {

    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    OrderItemRepository orderItemRepository;

    @GetMapping("/order/{id}") // /api/contatto/{id}
    public Order getOrder(@PathVariable Integer id) {
        System.out.println("api getOrder id : " + id);

        Order o = orderRepository.findById(id).get();
        System.out.println(o);

        return o;
    }
    
    @GetMapping("/cart")
    public List<OrderItem> getCart(HttpSession session)
    {
    	User utente = (User) session.getAttribute("user");
    	Order order = orderRepository.findByUserIdAndState(utente.getId(), "OPEN");
    	
    	return orderItemRepository.findByOrderId(order.getId());
    }
}
