package it.beije.ananke.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.Order_items;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.OrderRepository;
import it.beije.ananke.repository.Order_itemsRepository;
import it.beije.ananke.repository.UserRepository;

@Service
public class ServiceRepository {

	@Autowired
	private UserRepository userepository;
	@Autowired
	private Order_itemsRepository orderepository;
	@Autowired
	private OrderRepository orepository;
	
	public User findByEmail(String email) {
		return userepository.findByEmail(email);
	}
	
	public void save(User s) {
		 userepository.save(s);
	}
	
	public void saveorderitems(Order_items order,HttpSession session) {
		int iduser = (int) session.getAttribute("utente");
		if(orepository.findByUser_id(iduser) != null) {
		orderepository.save(order);
		}
	}
}
