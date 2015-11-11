package br.edu.fanor.progweb.ajudae.manager.ajudae;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.ajudae.bussines.CategoriaBO;
import br.edu.fanor.progweb.ajudae.bussines.PerguntaBO;
import br.edu.fanor.progweb.ajudae.entity.Categoria;
import br.edu.fanor.progweb.ajudae.entity.Pergunta;
import br.edu.fanor.progweb.ajudae.exceptions.BOException;
import br.edu.fanor.progweb.ajudae.to.SegurancaTO;
import br.edu.fanor.progweb.ajudae.utils.MessagesUtils;
import br.edu.fanor.progweb.ajudae.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadPergunta")
@Component(value="cadPergunta")
public class CadPerguntaManager {
	
	@Autowired
	private SegurancaTO segurancaTO;
	@Autowired
	private CategoriaBO categoriaBO;
	@Autowired
	private PerguntaBO perguntaBO;
	
	private String titulo;
	private String descricao;
	private Categoria categoria;

	public String preparaSalvar(){
		return Navigation.CADASTRO_PERGUNTA;
	}
	
	public String salvar(){
		
		Pergunta pergunta = new Pergunta();
		pergunta.setTitulo(this.titulo);
		pergunta.setDescricao(this.descricao);
		pergunta.setUsuario(segurancaTO.getUsuario());
		pergunta.setDataPergunta(new Date());
		pergunta.setCategoria(categoria);
		
		try {
			perguntaBO.salvar(pergunta);
			MessagesUtils.info("Pergunta salva com sucesso!");
			limparTela();
		} catch (BOException e) {
			MessagesUtils.error(e.getMessage());
			e.printStackTrace();
			return Navigation.FRACASSO;
		}
		
		return Navigation.SUCESSO;
	}
	
	private void limparTela() {
		this.titulo = "";
		this.descricao = "";
		this.categoria = null;
	}

	public List<SelectItem> getCategorias(){
		List<SelectItem> itens = new ArrayList<>();
		List<Categoria> categorias = this.categoriaBO.buscarTodos();
		for (Categoria categoria : categorias) {
			itens.add(new SelectItem(categoria, categoria.getDescricao()));
		}
		
		return itens;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
