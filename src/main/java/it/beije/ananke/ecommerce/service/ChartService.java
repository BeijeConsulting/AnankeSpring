package it.beije.ananke.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.model.Chart;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.repositories.ChartRepository;

@Service
public class ChartService {
	
	@Autowired
	ChartRepository chartRepository;

	public Chart addToChart(OrderItem orderItem, String name, String description, Integer userId) {
		Chart chart = chartRepository.findByOrderIdAndProductId(orderItem.getOrderId(), orderItem.getProductId());
		System.out.println("here??");
		if(chart!=null) {
			chart.setQuantity(orderItem.getQuantity());
			chart.setAmount(orderItem.getAmount());
			chartRepository.save(chart);
		} else {
			System.out.println("creating chart...");
			chart = new Chart();
			chart.setOrderId(orderItem.getOrderId());
			chart.setProductId(orderItem.getProductId());
			chart.setQuantity(orderItem.getQuantity());
			chart.setAmount(orderItem.getAmount());
			chart.setUserId(userId);
			chart.setName(name);
			chart.setDescription(description);
			chartRepository.save(chart);
		}
		return chart;	
	}
	
	public boolean checkChart(OrderItem orderItem){
		Chart charts = chartRepository.findByOrderIdAndProductId(orderItem.getOrderId(), orderItem.getProductId());
		if(charts != null) {
			return true;
		}
		return false;
	}
	
	
}
