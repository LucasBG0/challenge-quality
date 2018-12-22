package com.lucasbarbosa.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasbarbosa.challenge.domain.Foto;
import com.lucasbarbosa.challenge.repositories.FotoRepository;

@Service
public class FotoService {
	
	@Autowired
	private FotoRepository repo;
	
	public Foto buscar(Integer id) {
		Foto obj = repo.findOne(id);
		return obj;
	}

}
