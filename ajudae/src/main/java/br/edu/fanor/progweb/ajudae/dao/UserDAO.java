package br.edu.fanor.progweb.ajudae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.edu.fanor.progweb.ajudae.entity.Usuarios;

@Repository
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Usuarios> buscarPorNome(String nome) {
		Query query = em.createQuery("select u from user u where u.nome = :nome");
		query.setParameter("nome", nome);
		return query.getResultList();
	}

	public Usuarios getPorId(Long id) {
		return em.find(Usuarios.class, id);
	}
	
	public void guardar(Usuarios user) {
		em.persist(user);
	}
	
	public void editar(Usuarios user) {
		em.merge(user);
	}

	public void deletar(Usuarios user) {
		em.remove(user);
	}
	
}
