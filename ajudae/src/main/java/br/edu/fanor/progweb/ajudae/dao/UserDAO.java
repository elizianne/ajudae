package br.edu.fanor.progweb.ajudae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.edu.fanor.progweb.ajudae.entity.Users;

@Repository
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Users> buscarPorNome(String nome) {
		Query query = em.createQuery("select u from user u where u.nome = :nome");
		query.setParameter("nome", nome);
		return query.getResultList();
	}

	public Users getPorId(Long id) {
		return em.find(Users.class, id);
	}
	
	public void guardar(Users user) {
		em.persist(user);
	}
	
	public void editar(Users user) {
		em.merge(user);
	}

	public void deletar(Users user) {
		em.remove(user);
	}
	
}
