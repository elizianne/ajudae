package br.edu.fanor.progweb.ajudae.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class PontuacaoDAO {
	
	@PersistenceContext
	private EntityManager em;

}
