package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Departamento;
import com.github.mdssjc.k19.jpa.modelo.Funcionario;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class DepartamentoJpaTest extends JpaEntityManager {

  @Test
  public void adicionaDepartamentoFuncionario() {
    final Funcionario funcionario = new Funcionario();
    funcionario.setNome("Rafael Cosentino");

    final Departamento departamento = new Departamento();
    departamento.setNome("Financeiro");
    departamento.getFuncionarios()
                .add(funcionario);

    JpaEntityManager.manager.persist(departamento);

    final Departamento resultado = JpaEntityManager.manager.find(
        Departamento.class,
        departamento.getId());

    assertEquals(resultado, departamento);
  }
}
