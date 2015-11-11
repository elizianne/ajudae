package br.edu.fanor.progweb.ajudae.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.ajudae.bussines.CategoriaBO;
import br.edu.fanor.progweb.ajudae.entity.Categoria;

@RequestScoped
@ManagedBean(name = "categoriaConverter")
@Component(value = "categoriaConverter")
public class CategoriaConverter implements Converter {
	
	@Autowired
	private CategoriaBO categoriaBO;

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("Selecione um trajeto")) {
				return this.categoriaBO.listarPorID(Integer.valueOf(value));
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComponent, Object value) {

		if (value != null) {
			return String.valueOf(((Categoria) value).getId());
		} else {
			return null;
		}

	}

}
