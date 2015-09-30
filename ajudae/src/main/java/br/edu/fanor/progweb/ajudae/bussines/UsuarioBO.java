package br.edu.fanor.progweb.ajudae.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.ajudae.aspectj.Loggable;
import br.edu.fanor.progweb.ajudae.aspectj.PermitAll;
import br.edu.fanor.progweb.ajudae.aspectj.RolesAllowed;
import br.edu.fanor.progweb.ajudae.dao.UsuarioDAO;
import br.edu.fanor.progweb.ajudae.entity.Users;
import br.edu.fanor.progweb.ajudae.exceptions.BOException;
import br.edu.fanor.progweb.ajudae.exceptions.DAOException;

/**
 * @author patrick.cunha
 * 
 */
@Loggable
@Service
public class UsuarioBO {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public void salvar(Users usuario) throws BOException {
		usuario.setAdministrador(false);
		
		Users usuarioComMesmoLogin = this.usuarioDAO.buscarPorLogin(usuario.getLogin());
		if(usuarioComMesmoLogin != null){
			throw new BOException("Login já cadastrado!");
		}
		
		Users usuarioComMesmoEmail = this.usuarioDAO.buscarPorEmail(usuario.getEmail());
		if(usuarioComMesmoEmail != null){
			throw new BOException("Email já cadastrado!");
		}
		
		usuarioDAO.salvar(usuario);
	}

	@RolesAllowed(value = { "ALTERAR_USUARIO" })
	public void atualizar(Users usuario) {
		usuarioDAO.atualizar(usuario);
	}

	@PermitAll
	@Loggable(enable = false)
	public Users loggar(String email, String senha) {
		return usuarioDAO.buscarPorEmailSenha(email, senha);
	}

	@PermitAll
	@Loggable(enable = false)
	public Users buscarUsuarioPorEmail(String email) {
		return usuarioDAO.buscarPorEmail(email);
	}

	@RolesAllowed(value = { "LISTAR_USUARIO" })
	@Loggable(enable = false)
	public List<Users> listaUsuarioPorNome(String nome) {
		List<Users> Users = usuarioDAO.listarPorNome(nome);
		return Users;
	}

	@PermitAll
	@Loggable(enable = false)
	public Users buscarPorId(Integer id) {
		try {
			return usuarioDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RolesAllowed(value = { "EXCLUIR_USUARIO" })
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluir(Users usuario) {
		try {
			usuario = usuarioDAO.buscaPorId(usuario.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		usuarioDAO.excluir(usuario);
	}

}
