package br.edu.fanor.progweb.ajudae.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pontuacao")
public class Pontuacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users id_user;

	@Column(nullable = false)
	private Integer quantidadePontos;

	@ManyToOne
	@JoinColumn(name = "resposta_id", nullable = false)
	private RespostaPrincipal resposta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getId_user() {
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}

	public Integer getQuantidadePontos() {
		return quantidadePontos;
	}

	public void setQuantidadePontos(Integer quantidadePontos) {
		this.quantidadePontos = quantidadePontos;
	}

	public RespostaPrincipal getResposta() {
		return resposta;
	}

	public void setResposta(RespostaPrincipal resposta) {
		this.resposta = resposta;
	}

}
