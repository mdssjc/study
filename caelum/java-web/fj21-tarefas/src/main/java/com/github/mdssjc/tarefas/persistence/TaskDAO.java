package com.github.mdssjc.tarefas.persistence;

import com.github.mdssjc.tarefas.entity.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.List;

@Repository
public class TaskDAO implements ITaskDAO {

  @PersistenceContext
  private EntityManager manager;

  public TaskDAO() {
  }

  @Override
  public void save(final Task task) {
    this.manager.persist(task);
    System.out.println("tarefa adicionada");
  }

  @Override
  public Task findById(final long id) {
    return this.manager.find(Task.class, id);
  }

  @Override
  public List<Task> findAll() {
    return this.manager.createQuery("SELECT t FROM tarefas t")
                       .getResultList();
  }

  @Override
  public void set(final Task task) {
    this.manager.merge(task);
  }

  @Override
  public void delete(final Task task) {
    final Task taskRemoved = findById(task.getId());
    this.manager.remove(taskRemoved);
  }

  @Override
  public void closeTask(final Long id) {
    final Task task = findById(id);
    task.setFinalizado(true);
    task.setDataFinalizacao(Calendar.getInstance());
  }
}
