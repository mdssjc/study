package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.Calendar;
import java.util.List;

public class EncerradorDeLeilao {

  private int             total;
  private final LeilaoDao dao;
  private final Carteiro  carteiro;

  public EncerradorDeLeilao(final LeilaoDao dao, final Carteiro carteiro) {
    this.dao = dao;
    this.carteiro = carteiro;
  }

  public void encerra() {
    final List<Leilao> todosLeiloesCorrentes = this.dao.correntes();

    for (final Leilao leilao : todosLeiloesCorrentes) {
      try {
        if (comecouSemanaPassada(leilao)) {
          leilao.encerra();
          this.total++;
          this.dao.atualiza(leilao);
          this.carteiro.envia(leilao);
        }
      } catch (final Exception e) {
        System.err.println(e);
      }
    }
  }

  public int getTotalEncerrados() {
    return this.total;
  }

  private boolean comecouSemanaPassada(final Leilao leilao) {
    return diasEntre(leilao.getData(), Calendar.getInstance()) >= 7;
  }

  private int diasEntre(final Calendar inicio, final Calendar fim) {
    final Calendar data = (Calendar) inicio.clone();
    int diasNoIntervalo = 0;
    while (data.before(fim)) {
      data.add(Calendar.DAY_OF_MONTH, 1);
      diasNoIntervalo++;
    }
    return diasNoIntervalo;
  }
}
