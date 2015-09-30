package br.edu.fanor.progweb.ajudae.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sub_resposta")
public class SubResposta{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private Users usuario;

	@ManyToOne
	@JoinColumn(name="resposta_principal_id", nullable = false)
	private RespostaPrincipal respostaPrincipal;

	@Column(name="data_resposta",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataResposta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Users getUsuario() {
		return usuario;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	public RespostaPrincipal getRespostaPrincipal() {
		return respostaPrincipal;
	}

	public void setRespostaPrincipal(RespostaPrincipal respostaPrincipal) {
		this.respostaPrincipal = respostaPrincipal;
	}

	public Date getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}

}
