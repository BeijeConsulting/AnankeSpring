package it.beije.ananke.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import it.beije.ananke.model.User;

public interface UserManager {

	boolean setUser(User contatto) throws IOException, SQLException;
	void removeUser(String email);
	void updateUser(User user) ;
	User getUser(String email) ;
	List<User> getAllUsers();
	
}