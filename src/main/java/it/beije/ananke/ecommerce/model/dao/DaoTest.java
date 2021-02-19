package it.beije.ananke.ecommerce.model.dao;

import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;

public class DaoTest {
	public static void main(String[] args) {
		Product p = new Product();
//		p.setDescription("costoso");
//		p.setName("Iphone");
//		p.setPrice(1299.99);
		it.beije.ananke.ecommerce.model.dao.JpaDao dao = new JpaDao();
//		dao.persist((Object) p);
		
		User u = new User();
		u.setEmail("as@gmail.com");
		u.setPassword("lucagianni");
		dao.persist(u);
		
//		List<Product> list = dao.selectByField(p.getClass(), "description", "costoso");
//		for(Product pr : list) {
//			System.out.println(pr.getDescription());
//		}
		
	}
}
