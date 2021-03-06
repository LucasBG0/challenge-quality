package com.lucasbarbosa.challenge.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasbarbosa.challenge.domain.Foto;
import com.lucasbarbosa.challenge.repositories.FotoRepository;

@Service
public class DBService {
	
	@Autowired
	private FotoRepository fotoRepository;
	
	public void instantiateTestDatabase() {
		Foto foto1 = new Foto(null, "-15.881257", "-48.084766");
		Foto foto2 = new Foto(null, "-111.22233", "-15.881257");
		Foto foto3 = new Foto(null, "-2.2322323", "-15.881257");
		Foto foto4 = new Foto(null, "-37.553343", "-15.881257");
		Foto foto5 = new Foto(null, "-44.111133", "-15.881257");
		Foto foto6 = new Foto(null, "-16.232323", "-15.881257");
		Foto foto7 = new Foto(null, "-12.55555", "-15.881257");
		Foto foto8 = new Foto(null, "-1212.1212", "-15.881257");
		
		fotoRepository.save(Arrays.asList(foto1,foto2, foto3, foto4, foto5, foto6, foto7, foto8));			
		
	}
}
