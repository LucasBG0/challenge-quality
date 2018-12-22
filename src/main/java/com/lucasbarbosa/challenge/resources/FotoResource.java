package com.lucasbarbosa.challenge.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasbarbosa.challenge.domain.Foto;
import com.lucasbarbosa.challenge.services.FotoService;

@RestController
@RequestMapping(value="/fotos")
public class FotoResource {
	
	@Autowired
	private FotoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Foto obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
