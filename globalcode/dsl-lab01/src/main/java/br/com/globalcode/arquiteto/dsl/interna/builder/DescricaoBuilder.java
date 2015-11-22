package br.com.globalcode.arquiteto.dsl.interna.builder;

public class DescricaoBuilder {
    private final String descricao;

    public DescricaoBuilder(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
