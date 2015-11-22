package br.com.globalcode.arquiteto.dsl.interna.domain;

import java.util.Collection;

public interface Produto {
    
    Categoria getCategoria();
    
    String getNome();

    String getDescricao();

    String getFabricante();

    float getValor();

    Collection<String> getTags();

}
