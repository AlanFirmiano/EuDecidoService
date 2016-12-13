package com.br.eudecido.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Credencial;
import com.br.eudecido.models.Politico;
import com.br.eudecido.repository.CredencialRepository;

@Service
public class CredencialService {
	@Autowired
	private CredencialRepository repository;
	@Autowired
	private PoliticoService pService;

	public String salvarPolitico(Politico politico) {
		Credencial c = repository.findByCredencial(politico.getCredencial().getCredencial());
		if (c != null) {
			politico.setCredencial(c);
			
			Date inicio = new Date(System.currentTimeMillis());
			Date fim;
			
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(inicio);
			calendario.set(Calendar.MONTH, 1);
			calendario.set(Calendar.DAY_OF_MONTH, 1);
			
			politico.setInicio_mandado(inicio);
			
			calendario.set(Calendar.MONTH, 12);
			calendario.set(Calendar.DAY_OF_MONTH, 31);
			calendario.add(Calendar.YEAR, +4);
			fim = calendario.getTime();
			
			
			politico.setFim_mandato(fim);
			
			return pService.salvar(politico);
		}
		return "erro";
	}
	
	public String salvarCredencial(Credencial credencial){
		repository.save(credencial);
		return "sucesso";
	}
}
