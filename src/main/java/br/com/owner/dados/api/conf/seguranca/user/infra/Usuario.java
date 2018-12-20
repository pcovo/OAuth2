package br.com.owner.dados.api.conf.seguranca.user.infra;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Entity
public class Usuario {

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Getter
	private String nome;

	@Getter
	@JsonIgnore
	private Credenciais credenciais;

	@Deprecated
	Usuario() {
	}

	public Usuario(String nome, Credenciais credenciais) {
		super();
		this.nome = nome;
		this.credenciais = credenciais;
	}

}
