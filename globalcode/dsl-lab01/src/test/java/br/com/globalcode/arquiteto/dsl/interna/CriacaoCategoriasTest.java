package br.com.globalcode.arquiteto.dsl.interna;

import java.util.Collection;

import br.com.globalcode.arquiteto.dsl.interna.domain.Categoria;
import org.junit.Test;

import static br.com.globalcode.arquiteto.dsl.interna.builder.BuildersUtil.*;
import static org.fest.assertions.Assertions.*;

public class CriacaoCategoriasTest extends BaseDomainTest {

    @Test
    public void criarCategorias() {
        final Collection<Categoria> categorias = categorias(
                categoria(
                        nome("Telefonia Móvel"), descricao("Celulares e Smartphones"),
                        produto(
                                nome("iFone 4Z"),
                                descricao("Telefone celular de última geração."),
                                fabricante("PineApple"),
                                valor(1200.99f),
                                tags("smartphone", "ifone", "moda", "beleza")
                        ),
                        produto(
                                nome("Universe <3"),
                                descricao("Telefone celular basedo em tecnologia aberta."),
                                fabricante("Sammzunk"),
                                valor(1100.99f),
                                tags("smartphone", "universe", "aberto", "zoogle", "robot"))
                ),
                categoria(
                        nome("Torradeiras"), descricao(""),
                        produto(
                                nome("Torradeira Jorge Forma - Luxo III"),
                                descricao("Torradeira moderna que não gruda e elimina gordura."),
                                fabricante("--"),
                                valor(99.99f),
                                tags("torradeira", "gordura", "promoção", "pão")
                        )
                )
        );

        assertThat(categorias).isNotEmpty().hasSize(2);

        checkCategorias(categorias);
    }

    @Override public void checkTelefoniaMovelEspecifico(Categoria categoria) {
    }

    @Override public void checkTorradeirasEspecifico(Categoria categoria) {
    }
}
