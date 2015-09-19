package br.edu.fanor.progweb.ajudae.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_resposta")
public class SubResposta{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String descricao;

	@ManyToOne
	@Column(nullable = false)
	private Users id_user;

	@Column(nullable = false)
	private Integer id_pergPrinc;

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
		return id_user;
	}

	public void setId_user(Users id_user) {
		this.id_user = id_user;
	}

	public Integer getId_pergPrinc() {
		return id_pergPrinc;
	}

	public void setId_pergPrinc(Integer id_pergPrinc) {
		this.id_pergPrinc = id_pergPrinc;
	}

	public String getDt_resp() {
		return dt_resp;
	}

	public void setDt_resp(String dt_resp) {
		this.dt_resp = dt_resp;
	}

}
