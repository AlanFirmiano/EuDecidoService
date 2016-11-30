package com.br.eudecido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Comentario;
import com.br.eudecido.models.Projeto;
import com.br.eudecido.models.Reacao;
import com.br.eudecido.models.Usuario;
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
	
	public List<Projeto> listarPorUsuario(Usuario usuario){
		return repositoryProjeto.findByUsuario(usuario);
	}
	
	public List<Projeto> listarPorNome(String nome){
		return repositoryProjeto.findByNomeContainingIgnoreCase(nome);
	}
	
	public Projeto buscarPorId(Integer id){
		return repositoryProjeto.findById(id);
	}
	
	
	// Parte Reacao
	
	public void salvarReacao(Reacao reacao){
		repositoryReacao.save(reacao);
	}
	
	public void excluirReacao(Integer id){
		repositoryReacao.delete(id);
	}
	
	public Reacao buscarReacaoPorUsuarioEProjeto(Usuario usuario, Projeto projeto){
		return repositoryReacao.findByUsuarioAndProjeto(usuario, projeto);
	}
	
	// Parte Comentario
	
	public void salvarComentario(Comentario comentario){
		repositoryComentario.save(comentario);
	}
	
	public void excluirComentario(Integer id){
		repositoryComentario.delete(id);
	}
}
