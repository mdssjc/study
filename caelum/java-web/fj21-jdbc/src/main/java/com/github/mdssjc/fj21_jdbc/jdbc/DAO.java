package com.github.mdssjc.fj21_jdbc.jdbc;

import com.github.mdssjc.fj21_jdbc.entity.Contato;

import java.util.List;

public interface DAO {

  void add(Contato contato) throws RuntimeException;

  Contato get(long id);

  List<Contato> listAll() throws RuntimeException;

  void update(Contato contato) throws RuntimeException;

  void remove(Contato contato) throws RuntimeException;
}
