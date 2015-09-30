package br.edu.fanor.progweb.ajudae.manager.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.ajudae.bussines.UsuarioBO;
import br.edu.fanor.progweb.ajudae.entity.Users;
import br.edu.fanor.progweb.ajudae.exceptions.BOException;
import br.edu.fanor.progweb.ajudae.utils.Encripta;
import br.edu.fanor.progweb.ajudae.utils.MessagesUtils;
import br.edu.fanor.progweb.ajudae.utils.Navigation;
/**
 * @author patrick.cunha
 * 
 */
@RequestScoped
@ManagedBean(name="cadUsuario")
@Component(value="cadUsuario")
public class CadUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private ListUsuarioManager listUsuario;
	private String nome;
	private String email;
	private String senha;
	private String login;
	
	public String salvar(){
		
		Users usuario = new Users();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(Encripta.encripta(senha));
		usuario.setLogin(login);
		
		try {
			usuarioBO.salvar(usuario);
			MessagesUtils.info("Usuário salvo com sucesso!");
		} catch (BOException e) {
			MessagesUtils.error(e.getMessage());
			e.printStackTrace();
			return Navigation.FRACASSO;
		}
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.CADASTRO;
	}
			
	public void limpaDados(){
		this.nome = "";
		this.email = "";
		this.senha = "";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
