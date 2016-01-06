package br.com.k19.managebeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.entidades.Produto;
import br.com.k19.sessionbeans.ProdutoRepositorio;

@ManagedBean
public class ProdutoMB {

    @EJB
    private ProdutoRepositorio repositorio;

    private Produto            produto = new Produto();

    private List<Produto>      produtoCache;

    public void adiciona() {
        repositorio.adiciona(getProduto());
        setProduto(new Produto());
        produtoCache = null;
    }

    public List<Produto> getProdutos() {
        if (produtoCache == null) {
            produtoCache = repositorio.getProdutos();
        }
        return produtoCache;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
