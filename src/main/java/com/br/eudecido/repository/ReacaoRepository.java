package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Projeto;
import com.br.eudecido.models.Reacao;
import com.br.eudecido.models.Usuario;

public interface ReacaoRepository extends JpaRepository<Reacao, Integer> {
	
	Reacao findByUsuarioAndProjeto(Usuario usuario, Projeto projeto);
}
