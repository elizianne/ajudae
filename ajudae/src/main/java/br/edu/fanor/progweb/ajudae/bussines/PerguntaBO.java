package br.edu.fanor.progweb.ajudae.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.ajudae.dao.PerguntaDAO;
import br.edu.fanor.progweb.ajudae.entity.Pergunta;
import br.edu.fanor.progweb.ajudae.exceptions.BOException;

@Component
@Transactional
public class PerguntaBO {

	@Autowired
	private PerguntaDAO perguntaDAO;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void salvar(Pergunta pergunta) throws BOException {
		try {
			perguntaDAO.salvar(pergunta);
		} catch (Exception e) {
			throw new BOException("Não foi possível salvar a pergunta", e);
		}
	}

}
