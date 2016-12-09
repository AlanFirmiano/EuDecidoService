package com.br.eudecido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Credencial;
import com.br.eudecido.repository.CredencialRepository;

@Service
public class CredencialService {
	@Autowired
	private CredencialRepository repository;
	
	public Credencial credencial(String credencialRecebida){
		Credencial credencial = repository.findByCredencial(credencialRecebida);
		if(credencial != null){
			return credencial;
		}
		return null;
	}
}
