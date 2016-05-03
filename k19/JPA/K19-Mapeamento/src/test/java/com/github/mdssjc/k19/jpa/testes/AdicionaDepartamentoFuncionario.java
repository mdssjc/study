package com.github.mdssjc.k19.jpa.testes;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Departamento;
import com.github.mdssjc.k19.jpa.modelo.Funcionario;

public class AdicionaDepartamentoFuncionario {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

    final Funcionario f = new Funcionario();
    f.setNome("Rafael Cosentino");

    final Departamento d = new Departamento();
    d.setNome("Financeiro");
    d.getFuncionarios()
     .add(f);

    manager.persist(f);
    manager.persist(d);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}
