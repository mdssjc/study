package br.com.globalcode.arquiteto.dsl.interna.domain.impl;

import java.util.ArrayList;
import java.util.Collection;

import br.com.globalcode.arquiteto.dsl.interna.domain.Categoria;
import br.com.globalcode.arquiteto.dsl.interna.domain.Produto;

import static com.google.common.base.Preconditions.*;

public class CategoriaImpl implements Categoria {

    final String nome;
    final String descr;
    final Collection<Produto> produtos;

    public CategoriaImpl(final String nome, final String descr, final Collection<Produto> produtos) {
        this.nome = checkNotNull(nome);
        this.descr = checkNotNull(descr);
        this.produtos = checkNotNull(produtos);
    }

    public CategoriaImpl(final String nome, final String descr) {
        this(nome, descr, new ArrayList<Produto>());
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return descr;
    }

    @Override
    public Collection<Produto> getProdutos() {
        return produtos;
    }
}
