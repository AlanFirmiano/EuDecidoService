package com.br.eudecido.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Credencial;
import com.br.eudecido.models.CredenciamentoPolitico;
import com.br.eudecido.models.Politico;
import com.br.eudecido.models.Usuario;
import com.br.eudecido.repository.CredencialRepository;

@Service
public class CredencialService {
	@Autowired
	private CredencialRepository repository;
	@Autowired
	private PoliticoService pService;
	@Autowired
	private UsuarioService uService;

	public String credencial(CredenciamentoPolitico credenciamento) {
		Usuario usuario = credenciamento.getUsuario();
		Credencial c = repository.findByCredencial(credenciamento
				.getCredencial());
		if (c != null) {
			Politico p = new Politico();
			p.setId(usuario.getId());
			Date inicio = new Date(System.currentTimeMillis());
			p.setInicio_mandado(inicio);
			Date fim = new Date(System.currentTimeMillis());
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(fim);
			calendario.add(Calendar.YEAR, +4);
			fim = calendario.getTime();
			p.setFim_mandato(fim);
			pService.salvar(p);
			return "sucesso";
		}
		return "erro";
	}
}
