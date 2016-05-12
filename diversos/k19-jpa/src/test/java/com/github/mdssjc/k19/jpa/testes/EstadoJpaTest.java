package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Estado;
import com.github.mdssjc.k19.jpa.modelo.Governador;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class EstadoJpaTest extends JpaEntityManager {

  @Test
  public void adicionaEstadoGovernador() {
    final Governador governador = new Governador();
    governador.setNome("Rafael Cosentino");

    final Estado estado = new Estado();
    estado.setNome("São Paulo");
    estado.setGovernador(governador);

    JpaEntityManager.manager.persist(estado);

    final Estado resultado = JpaEntityManager.manager.find(Estado.class,
        estado.getId());

    assertEquals(resultado, estado);
  }
}
