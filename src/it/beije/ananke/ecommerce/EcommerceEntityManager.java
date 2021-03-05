package it.beije.ananke.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class EcommerceEntityManager {
	
	private static EntityManagerFactory emfactory = null;

	private EcommerceEntityManager() {}
	
	@Bean(name = "entityManagerFactory")	
	public static synchronized EntityManagerFactory getInstance() {
		try {
			if (emfactory == null) {
				emfactory = Persistence.createEntityManagerFactory("AnankeSpring");
			}
			return emfactory;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}