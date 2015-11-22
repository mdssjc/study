package br.com.globalcode.arquiteto.dsl.interna;

import java.util.Collection;

import br.com.globalcode.arquiteto.dsl.interna.domain.Categoria;
import br.com.globalcode.arquiteto.dsl.interna.domain.Produto;

import static org.fest.assertions.Assertions.*;
import static org.fest.assertions.Fail.*;

public abstract class BaseDomainTest {

    public void checkCategorias(Collection<Categoria> categorias) {
        assertThat(categorias).isNotNull().hasSize(2);

        for (final Categoria categoria : categorias) {
            if (categoria.getNome().equals("Telefonia Móvel")) {
                checkTelefoniaMovel(categoria);
            } else if (categoria.getNome().equals("Torradeiras")) {
                checkTorradeiras(categoria);
            } else {
                fail();
            }
        }
    }

    public void checkTelefoniaMovel(final Categoria categoria) {
        assertThat(categoria).isNotNull();

        assertThat(categoria.getNome()).isNotNull().isEqualTo("Telefonia Móvel");
        assertThat(categoria.getDescricao()).isNotNull().isEqualTo("Celulares e Smartphones");

        assertThat(categoria.getProdutos()).isNotNull().hasSize(2);

        checkTelefoniaMovelEspecifico(categoria);

        for (Produto produto : categoria.getProdutos()) {
            assertThat(produto.getCategoria()).isEqualTo(categoria);

            if (produto.getNome().equals("iFone 4Z")) {
                checkPhone4Z(produto);
            } else if (produto.getNome().equals("Universe <3")) {
                checkUnivers3(produto);
            } else {
                fail();
            }

        }
    }

    private void checkPhone4Z(final Produto produto) {
        assertThat(produto).isNotNull();
        assertThat(produto.getNome()).isEqualTo("iFone 4Z");
        assertThat(produto.getDescricao()).isEqualTo("Telefone celular de última geração.");
        assertThat(produto.getFabricante()).isEqualTo("PineApple");
        assertThat(produto.getValor()).isEqualTo(1200.99f);
        assertThat(produto.getTags()).isNotEmpty().hasSize(4).contains("smartphone", "ifone", "moda", "beleza");
    }

    private void checkUnivers3(final Produto produto) {
        assertThat(produto).isNotNull();
        assertThat(produto.getNome()).isEqualTo("Universe <3");
        assertThat(produto.getDescricao()).isEqualTo("Telefone celular basedo em tecnologia aberta.");
        assertThat(produto.getFabricante()).isEqualTo("Sammzunk");
        assertThat(produto.getValor()).isEqualTo(1100.99f);
        assertThat(produto.getTags()).isNotEmpty().hasSize(5).contains("smartphone", "universe", "aberto", "zoogle", "robot");

    }

    public void checkTorradeiras(final Categoria categoria) {
        assertThat(categoria).isNotNull();

        assertThat(categoria.getNome()).isNotNull().isEqualTo("Torradeiras");
        assertThat(categoria.getDescricao()).isEmpty();

        assertThat(categoria.getProdutos()).isNotNull().hasSize(1);

        checkTorradeirasEspecifico(categoria);

        checkTorradeiraJorgeForma(categoria.getProdutos().iterator().next());
    }

    private void checkTorradeiraJorgeForma(Produto produto) {
        assertThat(produto).isNotNull();
        assertThat(produto.getNome()).isEqualTo("Torradeira Jorge Forma - Luxo III");
        assertThat(produto.getDescricao()).isEqualTo("Torradeira moderna que não gruda e elimina gordura.");
        assertThat(produto.getFabricante()).isEqualTo("--");
        assertThat(produto.getValor()).isEqualTo(99.99f);
        assertThat(produto.getTags()).isNotEmpty().hasSize(4).contains("torradeira", "gordura", "promoção", "pão");
    }

    public abstract void checkTelefoniaMovelEspecifico(Categoria categoria);

    public abstract void checkTorradeirasEspecifico(Categoria categoria);

}
