/**
 * 
 */
package br.edu.fanor.progweb.ajudae.manager.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.ajudae.bussines.UsuarioBO;
import br.edu.fanor.progweb.ajudae.entity.Usuarios;
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
	private SegurancaTO segurancaTO;
	private String login;
	private String senha;

	public String loggar() {
		Usuarios usuario = this.usuarioBO.loggar(this.login,
				Encripta.encripta(this.senha));
		
		if (usuario != null) {
			segurancaTO.setUsuario(usuario);
			MessagesUtils.info("Bem vindo "+usuario.getNome());
			return Navigation.LOGADO;
		} else {
			MessagesUtils.error("O login ou a senha inseridos estão incorretos.");
			return Navigation.FRACASSO;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
