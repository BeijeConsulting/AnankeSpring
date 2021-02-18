package ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.services.*;
import ecommerce.entity.*;

@Controller
public class indexController {
@Autowired
private Order_ItemService orderItem_service; 

	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@GetMapping(value="getOrderItem")
	public String getOrderItem(@RequestParam Integer id, HttpSession session) {
		List<Order_Item> items = orderItem_service.findAllById(id);
		
		session.setAttribute("items", items);
		
		return "index";
	}
	
	@GetMapping(value="contacts")
	public String contactsPage() {
		return "contacts";
	}
	
}
