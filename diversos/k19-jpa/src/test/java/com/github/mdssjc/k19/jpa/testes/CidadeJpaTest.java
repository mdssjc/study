package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Cidade;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class CidadeJpaTest extends JpaEntityManager {

  @Test
  public void insereCidades() {
    final Cidade saoPaulo = new Cidade();
    saoPaulo.setNomeDaCidade("São Paulo");
    saoPaulo.setNomeDoEstado("São Paulo");

    final Cidade rioDeJaneiro = new Cidade();
    rioDeJaneiro.setNomeDaCidade("Rio de Janeiro");
    rioDeJaneiro.setNomeDoEstado("Rio de Janeiro");

    final Cidade natal = new Cidade();
    natal.setNomeDaCidade("Natal");
    natal.setNomeDoEstado("Rio Grande do Norte");

    JpaEntityManager.manager.persist(saoPaulo);
    JpaEntityManager.manager.persist(rioDeJaneiro);
    JpaEntityManager.manager.persist(natal);

    final Cidade sp = JpaEntityManager.manager.find(Cidade.class,
        saoPaulo.getId());
    final Cidade rj = JpaEntityManager.manager.find(Cidade.class,
        rioDeJaneiro.getId());
    final Cidade nl = JpaEntityManager.manager.find(Cidade.class,
        natal.getId());

    assertEquals(saoPaulo, sp);
    assertEquals(rioDeJaneiro, rj);
    assertEquals(natal, nl);
  }
}
