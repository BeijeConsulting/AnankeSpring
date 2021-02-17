package it.beije.ananke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.Users;
import it.beije.ananke.repository.UsersRepository;
@Service
public class UserService {
	@Autowired
	private UsersRepository usersRepository;
	
	public Users findByEmail(String email) {
		return usersRepository.findByEmail(email);
	}
public boolean addUser(String email, String name, String surname, String password)
{
Users c= new Users();
c.setEmail(email);
c.setFirstNname(name);
c.setSecondName(surname);
c.setPassword(password);
 c=usersRepository.save(c);
return c.getId()!=0;

}
}
