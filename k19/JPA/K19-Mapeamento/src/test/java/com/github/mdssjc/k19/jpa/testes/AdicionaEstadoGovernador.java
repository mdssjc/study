package com.github.mdssjc.k19.jpa.testes;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Estado;
import com.github.mdssjc.k19.jpa.modelo.Governador;

public class AdicionaEstadoGovernador {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

    final Governador g = new Governador();
    g.setNome("Rafael Cosentino");

    final Estado e = new Estado();
    e.setNome("São Paulo");
    e.setGovernador(g);

    manager.persist(g);
    manager.persist(e);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}
