package com.br.eudecido.security;

import javax.persistence.Entity;

public class Login {
	private String login;
	private String senha;

	public Login(){

	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
