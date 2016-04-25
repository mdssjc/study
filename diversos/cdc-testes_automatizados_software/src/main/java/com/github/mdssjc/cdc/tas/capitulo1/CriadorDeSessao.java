package com.github.mdssjc.cdc.tas.capitulo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class CriadorDeSessao {

  public Session getSession() {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "tas_pu");
    final EntityManager manager = factory.createEntityManager();
    return (Session) manager.getDelegate();
  }
}
