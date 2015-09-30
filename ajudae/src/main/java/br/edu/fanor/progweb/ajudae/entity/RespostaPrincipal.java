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
@Table(name = "princ_resposta")
public class RespostaPrincipal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@ManyToOne
	@JoinColumn(name = "pergunta_id", nullable = false)
	private Pergunta pergunta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_resposta", nullable = false)
	private Date dataResposta;
	
	@Column
	private Boolean escolhida;

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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Date getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}

	public Boolean getEscolhida() {
		return escolhida;
	}

	public void setEscolhida(Boolean escolhida) {
		this.escolhida = escolhida;
	}

}
