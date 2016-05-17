package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Estado;
import com.github.mdssjc.k19.jpa.modelo.Governador;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class EstadoJpaTest extends JpaEntityManager {

  private Governador governador;
  private Estado     estado;

  @Before
  public void criaMembros() {
    this.governador = new Governador();
    this.governador.setNome("Rafael Cosentino");

    this.estado = new Estado();
    this.estado.setNome("São Paulo");
  }

  @Test
  public void adicionaEstadoGovernador() {
    this.estado.setGovernador(this.governador);

    JpaEntityManager.manager.persist(this.estado);

    final Estado resultado = JpaEntityManager.manager.find(Estado.class,
        this.estado.getId());

    assertEquals(resultado, this.estado);
  }

  @Test
  public void adicionaGovernadorEstado() {
    this.governador.setEstado(this.estado);
    this.estado.setGovernador(this.governador);

    JpaEntityManager.manager.persist(this.estado);

    final Governador resultado = JpaEntityManager.manager.find(Governador.class,
        this.governador.getId());

    assertEquals(resultado, this.governador);
  }
}
