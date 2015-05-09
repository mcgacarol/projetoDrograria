package br.com.drogaria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CategoriaDAO;
import br.com.drogaria.domain.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaBean {
	
	private Categoria categoria;
	private List<Categoria> categorias;
	
	public void salvar(){
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		if(categoria.getCodigo()==null){
			categoriaDAO.salvar(categoria);
			Messages.addGlobalInfo("Categoria salva com sucesso");
		}else{
			categoriaDAO.editar(categoria);
			Messages.addGlobalInfo("Categoria alterada com sucesso");
		}
		iniciar();
	}
	
	public void excluir(){
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.excluir(categoria);
		Messages.addGlobalInfo("Categoria excluída com sucesso");
		iniciar();
	}
	
	@PostConstruct
	public void iniciar(){
		categoria = new Categoria();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categorias = categoriaDAO.listar();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
