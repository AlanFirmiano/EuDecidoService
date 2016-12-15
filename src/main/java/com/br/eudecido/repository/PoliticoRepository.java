package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Politico;

public interface PoliticoRepository extends JpaRepository<Politico, Integer>{
	
	Politico findById(Integer id);
}
