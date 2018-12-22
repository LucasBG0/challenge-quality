package com.lucasbarbosa.challenge;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucasbarbosa.challenge.domain.Foto;
import com.lucasbarbosa.challenge.repositories.FotoRepository;

@SpringBootApplication
public class ChallengeQualityApplication implements CommandLineRunner {
	
	@Autowired
	private FotoRepository fotoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ChallengeQualityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Foto foto1 = new Foto(null, "-15.881257", "-48.084766" );
		Foto foto2 = new Foto(null, "-111.22233", "-15.881257" );
		Foto foto3 = new Foto(null, "-2.2322323", "-15.881257" );
		Foto foto4 = new Foto(null, "-37.553343", "-15.881257" );
		Foto foto5 = new Foto(null, "-44.111133", "-15.881257" );
		Foto foto6 = new Foto(null, "-16.232323", "-15.881257" );
		Foto foto7 = new Foto(null, "-12.55555", "-15.881257" );
		Foto foto8 = new Foto(null, "-1212.1212", "-15.881257" );
		
		fotoRepository.save(Arrays.asList(foto1,foto2, foto3, foto4, foto5, foto6, foto7, foto8));			
	}

}

