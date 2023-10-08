package br.net.thaly.backend.model;

import java.io.Serializable;
import java.util.Date;

public class Funcionario implements Serializable {
	private int id;
	private String email;
	private String nome;
	private Date dataDeNasc;
	private String senha;
	private String perfil;
	
	
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(int id, String email, String nome, Date dataDeNasc, String senha, String perfil) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.dataDeNasc = dataDeNasc;
		this.senha = senha;
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getdataDeNasc() {
		return dataDeNasc;
	}

	public void setdataDeNasc(Date dataDeNasc) {
		this.dataDeNasc = dataDeNasc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
