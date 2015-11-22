package br.com.globalcode.arquiteto.dsl.interna.builder;

public class FabricanteBuilder {
    private final String fabricante;

    public FabricanteBuilder(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }
}
