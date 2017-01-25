package com.github.mdssjc.tarefas.jpa;

import com.github.mdssjc.tarefas.entity.Task;

import javax.persistence.EntityManager;

public class CarregaTarefa {

  public static void main(final String[] args) {
    final EntityManager manager = EMFactory.get();

    final Task result = manager.find(Task.class, 1L);
    System.out.println(result.getDescricao());

    manager.close();
  }
}
