package br.com.k19.sessionbeans;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateful;

@Stateful
public class CarrinhoBean {

    private Set<String> produtos = new HashSet<>();

    public void adiciona(String produto) {
        produtos.add(produto);
    }

    public void remove(String produto) {
        produtos.remove(produto);
    }

    public Set<String> getProdutos() {
        return produtos;
    }
}
