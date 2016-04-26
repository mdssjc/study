package com.github.mdssjc.cdc.tas;

import java.util.Calendar;

/**
 * Test Data Builders
 *
 */
public class CriadorDeLeilao {

  private Leilao leilao;

  public CriadorDeLeilao() {
  }

  public CriadorDeLeilao para(final String descricao) {
    this.leilao = new Leilao();
    this.leilao.setDescricao(descricao);
    return this;
  }

  public CriadorDeLeilao lance(final Usuario usuario, final double valor) {
    final Lance lance = new Lance();
    lance.setUsuario(usuario);
    lance.setValor(valor);
    this.leilao.propoe(lance);
    return this;
  }

  public CriadorDeLeilao naData(final Calendar antiga) {
    this.leilao.setDataAbertura(antiga);
    return this;
  }

  public Leilao constroi() {
    return this.leilao;
  }
}
