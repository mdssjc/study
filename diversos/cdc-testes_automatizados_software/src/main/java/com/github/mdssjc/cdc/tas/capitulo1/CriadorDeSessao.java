package com.github.mdssjc.cdc.tas.capitulo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CriadorDeSessao {

  public Session getSession() {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "tas_pu");
    final EntityManager manager = factory.createEntityManager();
    return (Session) manager.getDelegate();
  }

  public static void main(final String[] args) {
    final Session session = new CriadorDeSessao().getSession();

    final Transaction tx = session.beginTransaction();
    session.save(new Usuario("Teste"));
    tx.rollback();

    session.close();
  }
}
