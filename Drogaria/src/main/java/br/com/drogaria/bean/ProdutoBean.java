package br.com.drogaria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CategoriaDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Categoria;
import br.com.drogaria.domain.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	private Produto produto;
	private List<Produto> produtos;
	private List<Categoria> categorias;
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	@PostConstruct
	public void iniciar(){
		produto = new Produto ();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categorias = categoriaDAO.listar();
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtos = produtoDAO.listar();
	}
	
	public void salvar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		produtoDAO.salvar(produto);
		
		iniciar();
		
		Messages.addGlobalInfo("Produto salvo com sucesso");
	}
}

