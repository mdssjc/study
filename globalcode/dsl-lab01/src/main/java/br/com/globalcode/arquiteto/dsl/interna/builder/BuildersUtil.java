package br.com.globalcode.arquiteto.dsl.interna.builder;

import java.util.ArrayList;
import java.util.Collection;

import br.com.globalcode.arquiteto.dsl.interna.domain.Categoria;

public class BuildersUtil {

    public static ProductBuilder produto(NomeBuilder nome,
                                         DescricaoBuilder descricao,
                                         FabricanteBuilder fabricante,
                                         ValorBuilder valor, TagsBuilder tags) {
        return new ProductBuilder(nome, descricao, fabricante, valor, tags);
    }

    public static CategoriaBuilder categoria(NomeBuilder nome,
                                             DescricaoBuilder descricao,
                                             ProductBuilder... produto) {
        return new CategoriaBuilder(nome, descricao, produto);
    }

    public static Collection<Categoria> categorias(CategoriaBuilder... categorias) {
        Collection<Categoria> list = new ArrayList<Categoria>();

        for (CategoriaBuilder c : categorias) {
            list.add(c.getCategoria());
        }

        return list;
    }

    public static NomeBuilder nome(String nome) {
        return new NomeBuilder(nome);
    }

    public static DescricaoBuilder descricao(String descricao) {
        return new DescricaoBuilder(descricao);
    }

    public static FabricanteBuilder fabricante(String fabricante) {
        return new FabricanteBuilder(fabricante);
    }

    public static ValorBuilder valor(float valor) {
        return new ValorBuilder(valor);
    }

    public static TagsBuilder tags(String... tags) {
        return new TagsBuilder(tags);
    }
}
