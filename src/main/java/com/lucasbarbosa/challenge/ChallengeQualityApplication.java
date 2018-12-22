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
		Foto foto2 = new Foto(null, "-48.084766", "-15.881257" );
		
		fotoRepository.save(Arrays.asList(foto1,foto2));			
	}

}

