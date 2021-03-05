package it.beije.ananke.ecommerce.restcontroller;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order/{id}") // /api/contatto/{id}
    public Order getOrder(@PathVariable Integer id) {
        System.out.println("api getOrder id : " + id);

        Order o = orderRepository.findById(id).get();
        System.out.println(o);

        return o;
    }
}
