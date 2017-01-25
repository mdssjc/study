package com.github.mdssjc.tarefas.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

  public static void main(String[] args) {
    EntityManagerFactory em = Persistence.createEntityManagerFactory("pu-tasks");
    em.close();
  }
}
