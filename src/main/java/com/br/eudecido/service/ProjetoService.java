package com.br.eudecido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Projeto;
import com.br.eudecido.models.Usuario;
import com.br.eudecido.repository.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository repository;
	
	public void salvar(Projeto projeto){
		repository.save(projeto);
	}
	
	public void excluir(Integer id){
		repository.delete(id);
	}
	
	public List<Projeto> listar(){
		return repository.findAll();
	}
	
	public List<Projeto> listarPorUsuario(Usuario usuario){
		return repository.findByUsuario(usuario);
	}
}
