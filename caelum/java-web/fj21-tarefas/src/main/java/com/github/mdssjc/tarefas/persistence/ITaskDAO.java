package com.github.mdssjc.tarefas.persistence;

import com.github.mdssjc.tarefas.entity.Task;

import java.util.List;

public interface ITaskDAO extends DAO<Task> {

  @Override
  void save(Task task);

  @Override
  Task findById(long id);

  @Override
  List<Task> findAll();

  @Override
  void set(Task type);

  @Override
  void delete(Task type);

  void closeTask(Long id);
}
