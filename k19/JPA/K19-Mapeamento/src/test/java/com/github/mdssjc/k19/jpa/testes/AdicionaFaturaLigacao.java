package com.github.mdssjc.k19.jpa.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Fatura;
import com.github.mdssjc.k19.jpa.modelo.Ligacao;

public class AdicionaFaturaLigacao {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

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

    manager.persist(fatura);
    manager.persist(ligacao1);
    manager.persist(ligacao2);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}
