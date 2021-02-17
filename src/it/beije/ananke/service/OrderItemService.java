package it.beije.ananke.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.*;
import it.beije.ananke.repository.OrderItemRepository;
import it.beije.ananke.repository.OrderRepository;
import it.beije.ananke.repository.ProductRepository;
@Service
public class OrderItemService {
@Autowired
private OrderItemRepository orderItemRepository;
@Autowired
private ProductRepository productRepository;
@Autowired
private OrderRepository orderRepository;

public Order addOrderItem(Integer idUser, int idProduct, int quantity) {
	Order ordine=orderRepository.findByUserIDAndState(idUser, "open");
	if(ordine==null)
		{
		 ordine= new Order();
		 ordine.setState("open");
		 ordine.setUserID(idUser);
		 ordine.setAmount(0);
		 ordine=orderRepository.save(ordine);
	
 		}
OrderItem temp= orderItemRepository.findByOrderIDAndProductID(ordine.getId(), idProduct);
			if(temp==null) {
				temp=new OrderItem();
				temp.setOrderID(ordine.getId());
				temp.setProductID(idProduct);
				temp.setAmount(productRepository.findById(idProduct).get().getPrice()*quantity);
				ordine.setAmount(ordine.getAmount()+temp.getAmount());
				orderItemRepository.save(temp);
			return ordine;
			}

			temp.setQuantity(quantity);
			temp.setAmount(productRepository.findById(idProduct).get().getPrice()*quantity);
			orderItemRepository.save(temp);
			ordine.setAmount(ordine.getAmount()+temp.getAmount());
			orderRepository.save(ordine);
			
			return ordine;
}
public List<OrderItem> findByOrderID(int orderID) {
	return orderItemRepository.findByOrderID(orderID);
}

}
