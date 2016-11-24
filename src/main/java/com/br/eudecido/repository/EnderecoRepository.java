package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.eudecido.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	@Query("select e from Endereco e where e.id_endereco = ?1")
	Endereco findByUsuario(Integer id);
	
	Endereco findById(Integer id);

}
