package br.edu.fanor.progweb.ajudae.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.ajudae.dao.CategoriaDAO;
import br.edu.fanor.progweb.ajudae.entity.Categoria;

@Component
public class CategoriaBO {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	public List<Categoria> buscarTodos(){
		return categoriaDAO.findAll();
	}

	public Categoria listarPorID(Integer id) {
		return categoriaDAO.findById(id);
	}

}
