package br.edu.fanor.progweb.ajudae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.edu.fanor.progweb.ajudae.entity.Pergunta;

@Repository
public class PerguntaDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Pergunta> buscarPorTitulo(String titulo) {
		Query query = em.createQuery("select p from Perguntas p where p.titulo = :titulo");
		query.setParameter("titulo", titulo);
		return query.getResultList();
	}
	
	public Pergunta getPorId(Long id) {
		return em.find(Pergunta.class, id);
	}
	
	public void guardar(Pergunta perguntas){
		em.persist(perguntas);
	}
	
	public void editar(Pergunta perguntas){
		em.merge(perguntas);
	}

	public void deletar(Pergunta perguntas){
		em.remove(perguntas);
	}
	
}
