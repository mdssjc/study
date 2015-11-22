package br.com.globalcode.arquiteto.dsl.interna.domain;

import java.util.Collection;

public interface Categoria {

    String getNome();

    String getDescricao();

    Collection<Produto> getProdutos();
    
}
