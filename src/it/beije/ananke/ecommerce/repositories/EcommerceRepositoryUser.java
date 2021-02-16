package it.beije.ananke.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.beans.User;

@Repository
public interface EcommerceRepositoryUser extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

}
