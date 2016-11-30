package com.br.eudecido.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.eudecido.models.Comentario;
import com.br.eudecido.models.Projeto;
import com.br.eudecido.models.Reacao;
import com.br.eudecido.service.ProjetoService;

@Controller
@RestController
@RequestMapping(value = "/projetoController")
public class ProjetoController {
	
	@Autowired
	private ProjetoService pService;
	
	@RequestMapping(value = "/listarProjetos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Projeto>> getAllUsuarios(){
		return new ResponseEntity<List<Projeto>>(pService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> salvar(@RequestBody Projeto projeto){
		pService.salvar(projeto);
		return new ResponseEntity<String>("Projeto cadastrado!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/salvarReacao", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void salvarReacao(Reacao reacao){
		pService.salvarReacao(reacao);
	}
	
	@RequestMapping(value = "/excluirReacao", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void excluirReacao(Reacao reacao){
		pService.excluirReacao(reacao.getId());
	}
	
	@RequestMapping(value = "/salvarComentario", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void salvarComentario(Comentario comentario){
		pService.salvarComentario(comentario);
	}
	
	@RequestMapping(value = "/excluirComentario", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void excluirComentario(Comentario comentario){
		pService.excluirComentario(comentario.getId());
	}
	
}
