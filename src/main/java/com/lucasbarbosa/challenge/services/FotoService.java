package com.lucasbarbosa.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasbarbosa.challenge.domain.Foto;
import com.lucasbarbosa.challenge.repositories.FotoRepository;
import com.lucasbarbosa.challenge.services.exceptions.ObjectNotFoundException;

@Service
public class FotoService {
	
	@Autowired
	private FotoRepository repo;
	
	public Foto find(Integer id) {
		Foto obj = repo.findOne(id);
		if (obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Foto.class.getName());
		}
		return obj;
	}
	
	public Foto insert(Foto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.delete(id);
	}
}
