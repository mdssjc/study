package com.github.mdssjc.tarefas.jpa;

import com.github.mdssjc.tarefas.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class AdicionaTarefa {

  public static void main(final String[] args) {
    final Task task = new Task();
    task.setDescricao("Estudar JPA e Hibernate");
    task.setFinalizado(true);
    task.setDataFinalizacao(Calendar.getInstance());

    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu-tasks");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();
    manager.persist(task);
    manager.getTransaction()
           .commit();

    System.out.println("ID da tarefa: " + task.getId());

    manager.close();
  }
}
