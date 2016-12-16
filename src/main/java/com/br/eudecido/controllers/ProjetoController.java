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
	
	@RequestMapping(value = "/buscarProjetoPorId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Projeto> getUsuario(@RequestBody Integer id){
		return new ResponseEntity<Projeto>(pService.buscarPorId(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> salvar(@RequestBody Projeto projeto){
		return new ResponseEntity<String>(pService.salvar(projeto), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> excluir(@RequestBody Integer id){
		pService.excluir(id);
		return new ResponseEntity<String>("Deletado", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/salvarReacao", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> salvarReacao(@RequestBody Projeto projeto){
		return new ResponseEntity<String>(pService.salvarReacao(projeto), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/excluirReacao", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> excluirReacao(@RequestBody Reacao reacao){
		return new ResponseEntity<String>(pService.excluirReacao(reacao.getId()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/salvarComentario", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> salvarComentario(@RequestBody Projeto projeto){
		return new ResponseEntity<String>(pService.salvarComentario(projeto), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/excluirComentario", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> excluirComentario(@RequestBody Comentario comentario){
		return new ResponseEntity<String>(pService.excluirComentario(comentario.getId()), HttpStatus.OK);
	}
	
}
