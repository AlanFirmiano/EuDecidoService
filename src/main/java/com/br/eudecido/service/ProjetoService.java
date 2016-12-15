package com.br.eudecido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Comentario;
import com.br.eudecido.models.Politico;
import com.br.eudecido.models.Projeto;
import com.br.eudecido.models.Reacao;
import com.br.eudecido.repository.ComentarioRepository;
import com.br.eudecido.repository.ProjetoRepository;
import com.br.eudecido.repository.ReacaoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository repositoryProjeto;
	
	@Autowired
	private ReacaoRepository repositoryReacao;
	
	@Autowired
	private ComentarioRepository repositoryComentario;
	
	//Parte Projeto
	
	public void salvar(Projeto projeto){
		repositoryProjeto.save(projeto);
	}
	
	public void excluir(Integer id){
		repositoryProjeto.delete(id);
	}
	
	public List<Projeto> listar(){
		return repositoryProjeto.findAll();
	}
	
	public List<Projeto> listarPorUsuario(Politico politico){
		return repositoryProjeto.findByPolitico(politico);
	}
	
	public List<Projeto> listarPorNome(String nome){
		return repositoryProjeto.findByNomeContainingIgnoreCase(nome);
	}
	
	public Projeto buscarPorId(Integer id){
		return repositoryProjeto.findById(id);
	}
	
	public Projeto buscarPorIdNotLazy(Integer id){
		return repositoryProjeto.findByIdNotLazy(id);
	}
	
	
	// Parte Reacao
	
	public String salvarReacao(Reacao reacao){
		repositoryReacao.save(reacao);
		return "sucesso";
	}
	
	public String excluirReacao(Integer id){
		repositoryReacao.delete(id);
		return "sucesso";
	}
	
	// Parte Comentario
	
	public String salvarComentario(Comentario comentario){
		repositoryComentario.save(comentario);
		return "sucesso";
	}
	
	public String excluirComentario(Integer id){
		repositoryComentario.delete(id);
		return "sucesso";
	}
}
