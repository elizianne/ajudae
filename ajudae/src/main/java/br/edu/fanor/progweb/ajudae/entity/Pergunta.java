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
@Table(name = "pergunta")
public class Pergunta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private Users id_user;

	@ManyToOne
	@JoinColumn(name="categoria_id", nullable=false)
	private Categoria id_categoria;

	@Column(nullable = false)
	private String dt_pergunta;

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

	public Categoria getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDt_pergunta() {
		return dt_pergunta;
	}

	public void setDt_pergunta(String dt_pergunta) {
		this.dt_pergunta = dt_pergunta;
	}

}
