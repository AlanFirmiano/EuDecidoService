package com.br.eudecido.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Politico extends Usuario {

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "GMT-3")
	private Date inicio_mandado;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "GMT-3")
	private Date fim_mandato;
	@Column(nullable = false)
	private String cargo;
	
	@OneToOne(optional = true)
	@Cascade(CascadeType.ALL)
	private Credencial credencial;

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}
	
	

}
