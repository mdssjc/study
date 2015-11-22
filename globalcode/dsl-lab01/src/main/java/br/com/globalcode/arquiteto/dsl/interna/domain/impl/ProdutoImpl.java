package br.com.globalcode.arquiteto.dsl.interna.domain.impl;

import java.util.Collection;

import br.com.globalcode.arquiteto.dsl.interna.domain.Categoria;
import br.com.globalcode.arquiteto.dsl.interna.domain.Produto;

import static com.google.common.base.Preconditions.*;
import static java.util.Collections.*;

public class ProdutoImpl implements Produto {

    private Categoria categoria;
    private String nome;
    private String descr;
    private String fabricante;
    private float valor;
    private Collection<String> tags;

    public ProdutoImpl(final Categoria categoria, final String nome, final String descr, final String fabricante, final float valor, final Collection<String> tags) {
        this.categoria = checkNotNull(categoria);
        this.nome = checkNotNull(nome);
        this.descr = checkNotNull(descr);
        this.fabricante = checkNotNull(fabricante);
        this.valor = checkNotNull(valor);
        this.tags = unmodifiableCollection(checkNotNull(tags));
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
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
    public String getFabricante() {
        return fabricante;
    }

    @Override
    public float getValor() {
        return valor;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<String> getTags() {
        return tags;
    }
}
