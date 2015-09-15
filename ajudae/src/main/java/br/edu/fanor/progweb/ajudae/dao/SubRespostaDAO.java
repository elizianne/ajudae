package br.edu.fanor.progweb.ajudae.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.edu.fanor.progweb.ajudae.entity.SubResposta;

@Repository
public class SubRespostaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public SubResposta getPorId(Long id) {
		return em.find(SubResposta.class, id);
	}
	
	public void guardar(SubResposta subResposta){
		em.persist(subResposta);
	}
	
	public void editar(SubResposta subResposta){
		em.merge(subResposta);
	}

	public void deletar(SubResposta subResposta){
		em.remove(subResposta);
	}
}
