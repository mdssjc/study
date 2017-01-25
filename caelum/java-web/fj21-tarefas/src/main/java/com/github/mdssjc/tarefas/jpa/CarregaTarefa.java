package com.github.mdssjc.tarefas.jpa;

import com.github.mdssjc.tarefas.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarregaTarefa {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu-tasks");
    final EntityManager manager = factory.createEntityManager();

    final Task result = manager.find(Task.class, 1L);
    System.out.println(result.getDescricao());

    manager.close();
  }
}
