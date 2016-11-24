package com.br.eudecido.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Politico;
import com.br.eudecido.repository.PoliticoRepository;

@Service
public class PoliticoService {
	
	@Autowired
	private PoliticoRepository repository;
	
	public void salvar(Politico politico){
		repository.save(politico);
	}
	
	public Politico buscarPorId(Integer id){
		return repository.findById(id);
	}
	
	public List<Politico> buscarTodos(){
		return repository.findAll();
	}
	
	public boolean logar(Politico politico){
		Politico p = repository.findByEmailAndSenha(politico.getEmail(), politico.getSenha());
		
		if(p!=null)
			if(new Date().before(p.getFim_mandato()))
				return true;
		
		
		return false;
	}
}
