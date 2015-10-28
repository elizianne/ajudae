/**
 * 
 */
package br.edu.fanor.progweb.ajudae.manager.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.ajudae.bussines.UsuarioBO;
import br.edu.fanor.progweb.ajudae.entity.Users;
import br.edu.fanor.progweb.ajudae.to.SegurancaTO;
import br.edu.fanor.progweb.ajudae.utils.Encripta;
import br.edu.fanor.progweb.ajudae.utils.MessagesUtils;
import br.edu.fanor.progweb.ajudae.utils.Navigation;

/**
 * @author patrick.cunha
 * @since 26/06/2015
 */
@RequestScoped
@Component(value = "login")
@ManagedBean(name = "login")
public class LoginManager {

	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private SegurancaTO seguranca;
	private Users usuario = new Users();
	private boolean existsEmail;

	public String loggar() {
		Users usuario = this.usuarioBO.loggar(this.usuario.getEmail(),
				Encripta.encripta(this.usuario.getSenha()));
		this.usuario = new Users();
		if (usuario != null) {
			seguranca.setUsuario(usuario);
			existsEmail = true;
			MessagesUtils.info("Bem vindo "+usuario.getNome());
			return Navigation.SUCESSO;
		} else {
			existsEmail = false;
			MessagesUtils.error("O login ou a senha inseridos estão incorretos.");
			return Navigation.FRACASSO;
		}
	}

	/**
	 * @return the usuario
	 */
	public Users getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the existsEmail
	 */
	public boolean isExistsEmail() {
		return existsEmail;
	}

	/**
	 * @param existsEmail
	 *            the existsEmail to set
	 */
	public void setExistsEmail(boolean existsEmail) {
		this.existsEmail = existsEmail;
	}

}
