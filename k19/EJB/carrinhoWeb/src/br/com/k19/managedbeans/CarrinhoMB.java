package br.com.k19.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.k19.sessionbeans.Carrinho;

@ManagedBean
@SessionScoped
public class CarrinhoMB {

    @EJB
    private Carrinho carrinhoBean;

    private String       produto;

    public List<String> getProdutos() {
        return new ArrayList<String>(carrinhoBean.getProdutos());
    }

    public void adiciona() {
        carrinhoBean.adiciona(getProduto());
    }

    public void remove(String produto) {
        carrinhoBean.remove(produto);
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
