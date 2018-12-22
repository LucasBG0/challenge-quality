package com.lucasbarbosa.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasbarbosa.challenge.domain.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{
	
}