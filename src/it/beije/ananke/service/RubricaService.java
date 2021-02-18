package it.beije.ananke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.Contatto;
import it.beije.ananke.repository.ContattoRepository;

@Service
public class RubricaService {
	
	@Autowired
	private ContattoRepository contattoRepository;
	
	public Contatto save(Contatto contatto) {
		return contattoRepository.save(contatto);
	}

	public Contatto findByEmail(String email) {
		return findByEmail(email, false);
	}
	
	public Contatto findByEmail(String email, boolean notNull) {
		if (notNull && email == null) {
			return null;
		}
		
		return contattoRepository.findByEmail(email);
	}
	
	public Contatto checkAndSave(Contatto contatto) throws Exception {
//		if ((contatto.getTelephone() != null && contatto.getTelephone().length() > 0)
//				|| (contatto.getEmail() != null && contatto.getEmail().length() > 0)) {
		if (contatto.getEmail() != null && contatto.getEmail().length() > 0) {
			
			return save(contatto);
		}
		
		//throw new ContattoException();
		throw new Exception("mancano i dati obbligatori");
	}
	
	public List<Contatto> searchByFirstLettersOfSurname(String letters) {
		return contattoRepository.searchByFirstLettersOfSurname(letters);
	}
}
