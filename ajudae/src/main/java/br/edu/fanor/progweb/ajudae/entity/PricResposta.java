package br.edu.fanor.progweb.ajudae.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "princ_resposta")
public class PricResposta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private Users user;

	@ManyToOne
	@JoinColumn(name="pergunta", nullable=false)
	private Pergunta pergunta;

	@Column(nullable = false)
	private String dt_resp;

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

	public Users getId_user() {
		return user;
	}

	public void setId_user(Users id_user) {
		this.user = id_user;
	}

	public Pergunta getId_pergunta() {
		return pergunta;
	}

	public void setId_pergunta(Pergunta id_pergunta) {
		this.pergunta = id_pergunta;
	}

	public String getDt_resp() {
		return dt_resp;
	}

	public void setDt_resp(String dt_resp) {
		this.dt_resp = dt_resp;
	}
}
