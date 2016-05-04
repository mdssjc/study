package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Fatura;
import com.github.mdssjc.k19.jpa.modelo.Ligacao;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class LigacaoJpaTest extends JpaEntityManager {

  @Test
  public void adicionaFaturaLigacao() {
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

    final Fatura resultado = JpaEntityManager.manager.find(Fatura.class,
        fatura.getId());

    assertTrue(resultado.getLigacoes()
                        .contains(ligacao1));
    assertTrue(resultado.getLigacoes()
                        .contains(ligacao2));
  }
}
