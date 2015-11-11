package br.edu.fanor.progweb.ajudae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.ajudae.entity.Categoria;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class CategoriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public List<Categoria> findAll(){
		String hql = "select c from Categoria c";
		Query query = em.createQuery(hql);
		return (List<Categoria>)query.getResultList();
	}

	public void save(Categoria categoria){
		em.persist(categoria);
	}

	public Categoria findById(Integer id) {		
		return em.find(Categoria.class, id);
	}
	

}
