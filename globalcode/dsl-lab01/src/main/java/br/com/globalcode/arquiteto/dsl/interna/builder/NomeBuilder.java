package br.com.globalcode.arquiteto.dsl.interna.builder;

public class NomeBuilder {
    private final String nome;

    public NomeBuilder(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
