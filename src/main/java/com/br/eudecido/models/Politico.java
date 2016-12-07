package com.br.eudecido.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Politico extends Usuario {

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date inicio_mandado;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date fim_mandato;

	public Date getInicio_mandado() {
		return inicio_mandado;
	}

	public void setInicio_mandado(Date inicio_mandado) {
		this.inicio_mandado = inicio_mandado;
	}

	public Date getFim_mandato() {
		return fim_mandato;
	}

	public void setFim_mandato(Date fim_mandato) {
		this.fim_mandato = fim_mandato;
	}

}
