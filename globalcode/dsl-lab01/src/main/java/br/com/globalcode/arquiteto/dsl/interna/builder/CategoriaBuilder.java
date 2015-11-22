package br.com.globalcode.arquiteto.dsl.interna.builder;

import br.com.globalcode.arquiteto.dsl.interna.domain.impl.CategoriaImpl;

public class CategoriaBuilder {
    private final CategoriaImpl categoria;

    public CategoriaBuilder(NomeBuilder nome, DescricaoBuilder descricao,
            ProductBuilder... produtos) {
        this.categoria = new CategoriaImpl(nome.getNome(),
                descricao.getDescricao());

        for (ProductBuilder p : produtos) {
            p.makeProduto(categoria);
            this.categoria.getProdutos().add(p.getProduto());
        }
    }

    public CategoriaImpl getCategoria() {
        return categoria;
    }
}
