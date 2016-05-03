package com.github.mdssjc.k19.jpa.testes;

import java.util.GregorianCalendar;

import com.github.mdssjc.k19.jpa.modelo.Fatura;
import com.github.mdssjc.k19.jpa.modelo.Ligacao;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class AdicionaFaturaLigacao extends JpaEntityManager {

  public static void main(final String[] args) {
    final Ligacao ligacao1 = new Ligacao();
    ligacao1.setDuracao(162);

    final Ligacao ligacao2 = new Ligacao();
    ligacao2.setDuracao(324);

    final Fatura fatura = new Fatura();
    fatura.setVencimento(new GregorianCalendar(2012, 11, 20));

    fatura.getLigacoes()
          .add(ligacao1);
    fatura.getLigacoes()
          .add(ligacao2);

    ligacao1.setFatura(fatura);
    ligacao2.setFatura(fatura);

    JpaEntityManager.manager.persist(fatura);
    JpaEntityManager.manager.persist(ligacao1);
    JpaEntityManager.manager.persist(ligacao2);
  }
}
