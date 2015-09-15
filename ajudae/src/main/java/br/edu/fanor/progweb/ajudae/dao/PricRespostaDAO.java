package br.edu.fanor.progweb.ajudae.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.edu.fanor.progweb.ajudae.entity.PricResposta;


@Repository
public class PricRespostaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public PricResposta getPorId(Long id) {
		return em.find(PricResposta.class, id);
	}
	
	public void guardar(PricResposta pricResposta){
		em.persist(pricResposta);
	}
	
	public void editar(PricResposta pricResposta){
		em.merge(pricResposta);
	}

	public void deletar(PricResposta pricResposta){
		em.remove(pricResposta);
	}
	
}
