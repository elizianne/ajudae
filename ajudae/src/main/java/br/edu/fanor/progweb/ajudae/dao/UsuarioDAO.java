package br.edu.fanor.progweb.ajudae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.ajudae.entity.Usuarios;
import br.edu.fanor.progweb.ajudae.exceptions.DAOException;

/**
 * @author patrick.cunha
 * 
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Usuarios usuario) {
		entityManager.persist(usuario);
	}
	
	public void atualizar(Usuarios usuario){
		entityManager.merge(usuario);
	}
	
	public Usuarios buscarPorEmail(String email){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
		Root<Usuarios> Users = criteriaQuery.from(Usuarios.class);
		criteriaQuery.where(criteriaBuilder.equal(Users.<String>get("email"), email));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuarios)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	public Usuarios buscarPorLogin(String login){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
		Root<Usuarios> Users = criteriaQuery.from(Usuarios.class);
		criteriaQuery.where(criteriaBuilder.equal(Users.<String>get("login"), login));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuarios)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
		
	public Usuarios buscarPorEmailSenha(String email, String senha){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
		Root<Usuarios> Users = criteriaQuery.from(Usuarios.class);
		criteriaQuery.where(criteriaBuilder.equal(Users.<String>get("email"), email));
		criteriaQuery.where(criteriaBuilder.equal(Users.<String>get("senha"), senha));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuarios)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	public Usuarios buscarPorLoginSenha(String login, String senha){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
		Root<Usuarios> Users = criteriaQuery.from(Usuarios.class);
		criteriaQuery.where(criteriaBuilder.equal(Users.<String>get("login"), login));
		criteriaQuery.where(criteriaBuilder.equal(Users.<String>get("senha"), senha));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuarios)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuarios> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
		Root<Usuarios> Users = criteriaQuery.from(Usuarios.class);
		criteriaQuery.where(criteriaBuilder.like(Users.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Usuarios buscaPorId(Integer id) throws DAOException {
		String jpql = "select u from Users u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Usuarios) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
		
	}
	
	public void excluir(Usuarios usuario) {
		entityManager.remove(usuario);
	}
}
