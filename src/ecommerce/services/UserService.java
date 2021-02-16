package ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entity.User;
import ecommerce.repository.UserRepository;

@Service
public class UserService {

@Autowired
private UserRepository user_rep;

public boolean addUser(String fname, String lname, String email, String password) {
	if(user_rep.findByEmail(email) != null) {
		return false;
	}
	User u = new User();
	u.setName(fname);
	u.setLastName(lname);
	u.setEmail(email);
	u.setPassword(password);
	user_rep.save(u);
	return true;
}

public List<User> findAll(){
	return user_rep.findAll();
}

public User findByEmail(String email) {
	
return user_rep.findByEmail(email);
}

public User findByEmailAndPassword(String email, String password) {
	return user_rep.findByEmailAndPassword(email, password);
}

public User getOne(Integer id) {
	return user_rep.getOne(id);
}

public void delete(User u) {
	user_rep.delete(u);
}
}
