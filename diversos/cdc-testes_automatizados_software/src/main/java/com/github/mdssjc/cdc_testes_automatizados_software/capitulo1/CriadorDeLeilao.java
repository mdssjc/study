package com.github.mdssjc.cdc_testes_automatizados_software.capitulo1;

public class CriadorDeLeilao {

  private Leilao leilao;

  public CriadorDeLeilao() {
  }

  public CriadorDeLeilao para(final String descricao) {
    this.leilao = new Leilao(descricao);
    return this;
  }

  public CriadorDeLeilao lance(final Usuario usuario, final double valor) {
    this.leilao.propoe(new Lance(usuario, valor));
    return this;
  }

  public Leilao constroi() {
    return this.leilao;
  }
}
