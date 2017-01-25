package com.github.mdssjc.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {

  public static EntityManager get() {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu-tasks");
    return factory.createEntityManager();
  }
}
