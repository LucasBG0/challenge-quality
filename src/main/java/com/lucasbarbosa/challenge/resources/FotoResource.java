package com.lucasbarbosa.challenge.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasbarbosa.challenge.domain.Foto;

@RestController
@RequestMapping(value="/fotos")
public class FotoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Foto> listar() {
		
		Foto foto1 = new Foto(1, "-15.881257", "-48.084766");
		Foto foto2 = new Foto(2, "-48.084766", "-15.881257");
		
		List<Foto> lista = new ArrayList<>();
		lista.add(foto1);
		lista.add(foto2);
		
		return lista;
	}
}
