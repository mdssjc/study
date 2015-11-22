package br.com.globalcode.arquiteto.dsl.interna.builder;

import br.com.globalcode.arquiteto.dsl.interna.domain.Categoria;
import br.com.globalcode.arquiteto.dsl.interna.domain.impl.ProdutoImpl;

public class ProductBuilder {
    private ProdutoImpl             produto;
    private final NomeBuilder       nome;
    private final DescricaoBuilder  descricao;
    private final FabricanteBuilder fabricante;
    private final ValorBuilder      valor;
    private final TagsBuilder       tags;

    public ProductBuilder(NomeBuilder nome, DescricaoBuilder descricao,
            FabricanteBuilder fabricante, ValorBuilder valor,
            TagsBuilder tags) {
        this.nome = nome;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.valor = valor;
        this.tags = tags;
    }

    public void makeProduto(Categoria categoria) {
        this.produto = new ProdutoImpl(categoria, nome.getNome(),
                descricao.getDescricao(), fabricante.getFabricante(),
                valor.getValor(), tags.getTags());
    }

    public ProdutoImpl getProduto() {
        return produto;
    }
}
