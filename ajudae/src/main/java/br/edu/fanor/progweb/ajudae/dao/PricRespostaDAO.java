package br.edu.fanor.progweb.ajudae.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.edu.fanor.progweb.ajudae.entity.RespostaPrincipal;


@Repository
public class PricRespostaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public RespostaPrincipal getPorId(Long id) {
		return em.find(RespostaPrincipal.class, id);
	}
	
	public void guardar(RespostaPrincipal pricResposta){
		em.persist(pricResposta);
	}
	
	public void editar(RespostaPrincipal pricResposta){
		em.merge(pricResposta);
	}

	public void deletar(RespostaPrincipal pricResposta){
		em.remove(pricResposta);
	}
	
}
