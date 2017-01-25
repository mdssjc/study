package com.github.mdssjc.tarefas.jpa;

import com.github.mdssjc.tarefas.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BuscaTarefas {

  public static void main(final String[] args) {
    final EntityManager manager = EMFactory.get();

    final Query query = manager.createQuery("SELECT t FROM tarefas as t WHERE t.finalizado = :paramFinalizado");
    query.setParameter("paramFinalizado", true);

    query.getResultList()
         .forEach(t -> System.out.println(((Task) t).getDescricao()));

    manager.close();
  }
}
