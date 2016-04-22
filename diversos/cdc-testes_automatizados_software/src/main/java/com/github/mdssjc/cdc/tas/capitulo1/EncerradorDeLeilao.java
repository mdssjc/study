package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.Calendar;
import java.util.List;

public class EncerradorDeLeilao {

  private final LeilaoDao dao;
  private int             total;

  public EncerradorDeLeilao(final LeilaoDao dao) {
    this.dao = dao;
  }

  public void encerra() {
    final List<Leilao> todosLeiloesCorrentes = this.dao.correntes();

    for (final Leilao leilao : todosLeiloesCorrentes) {
      if (comecouSemanaPassada(leilao)) {
        leilao.encerra();
        this.total++;
        this.dao.salva(leilao);
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
