package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>  {

}
