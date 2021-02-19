package it.beije.ananke.ecommerce.controller.restcontroller;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.OrderItemRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;
import it.beije.ananke.ecommerce.repositories.ProductRepository;
import it.beije.ananke.ecommerce.repositories.UserRepository;
import it.beije.ananke.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/order/{id}") // /api/contatto/{id}
    public Order getOrder(@PathVariable Integer id) {
        System.out.println("api getOrder id : " + id);

        Order o = orderRepository.findById(id).get();
        System.out.println(o);

        return o;
    }

    @GetMapping("/myorders/{userId}")
    public List<Order> getMyOrder(@PathVariable Integer userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        for (Order o : orders) {
            System.out.println(o.getId());
        }
        return orders;
    }

    @PutMapping("confirmOrder/{id}")
    public Order confirmOrder(@PathVariable Integer id, @RequestBody Order order) {
        if (id.compareTo(order.getId()) == 0) {
            System.out.println("ID coerenti");

            Optional<Order> optC = orderRepository.findById(id);
            System.out.println("optC isPresent ? " + optC.isPresent());
            if (optC.isPresent()) {
                Order o = optC.get();
                if (order.getState().equalsIgnoreCase("open")) {
                    o.setAmount(order.getAmount());
                    o.setUserId(order.getUserId());
                    o.setState("close");
                    return orderRepository.save(o);
                } else throw new IllegalArgumentException("Order already closed");
            } else throw new IllegalArgumentException("ID order non trovato");
        } else throw new IllegalArgumentException("IDs non coerenti");
    }

    @PostMapping("/neworder")
    public Order newOrder(@RequestBody Order order) {
        Order o = orderService.openOrder(userRepository.findById(order.getUserId()).get());
        return o;
    }


}
