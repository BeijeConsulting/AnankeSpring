package it.beije.ananke.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.repositories.OrderItemRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;
import it.beije.ananke.ecommerce.repositories.ProductRepository;

@Service
public class OrderItemService {

	@Autowired
    OrderService orderService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public OrderItem addToChart(Integer orderId, Integer productId, Integer quantity, Double price) {
		
		OrderItem orderItem = orderItemRepository.findByOrderIdAndProductId(orderId, productId);
		if(orderItem != null) {
			orderItem.setQuantity(orderItem.getQuantity() + quantity);
			orderItem.setAmount(orderItem.getQuantity() * price);
			orderItemRepository.save(orderItem);
		} else {
			orderItem = new OrderItem();
			orderItem.setOrderId(orderId);
			orderItem.setProductId(productId);
			orderItem.setQuantity(quantity);
			orderItem.setAmount(quantity * price);
			orderItemRepository.save(orderItem);
		}
		return orderItem;
	}
	
	public List<OrderItem> getOrderItems(Integer orderId) {
		return orderItemRepository.findByOrderId(orderId);
	}
	
	public List<Product> showOrderItems(Integer orderId) {
		return productRepository.findItemsByOrderId(orderId);
	}

}
