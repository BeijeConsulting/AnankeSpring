package it.beije.ananke.ecommerce.model.dao;

import it.beije.ananke.ecommerce.model.User;

public class JpaUser extends JpaDao {
	
	public boolean authenticate(String email, String password) {
		User u = (User) super.selectByField(User.class, "email", email).get(0);
		if(u != null) {
			if (u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean register(User u) {
		String email = u.getEmail();
		if(super.selectByField(User.class, "email", email).isEmpty()) {
			super.persist((Object) u);
			return true;
		}
		return false;
	}
}
