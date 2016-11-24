package com.br.eudecido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Politico;

public interface PoliticoRepository extends JpaRepository<Politico, Integer>{
	
	List<Politico> findByNome(String nome);
	
	List<Politico> findByEmail(String email);
	
	Politico findByEmailAndSenha(String email, String senha);
	
	Politico findById(Integer id);
}
