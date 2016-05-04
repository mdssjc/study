package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Pessoa;
import com.github.mdssjc.k19.jpa.modelo.PessoaFisica;
import com.github.mdssjc.k19.jpa.modelo.PessoaJuridica;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class PessoaJpaTest extends JpaEntityManager {

  @Test
  public void adicionaPessoa() {
    final Pessoa p1 = new Pessoa();
    p1.setNome("Marcelo");

    final PessoaFisica p2 = new PessoaFisica();
    p2.setNome("Rafael");
    p2.setCpf("1234");

    final PessoaJuridica p3 = new PessoaJuridica();
    p3.setNome("K19");
    p3.setCnpj("567788");

    JpaEntityManager.manager.persist(p1);
    JpaEntityManager.manager.persist(p2);
    JpaEntityManager.manager.persist(p3);

    final Pessoa resultado1 = JpaEntityManager.manager.find(Pessoa.class,
        p1.getId());
    final Pessoa resultado2 = JpaEntityManager.manager.find(Pessoa.class,
        p2.getId());
    final Pessoa resultado3 = JpaEntityManager.manager.find(Pessoa.class,
        p3.getId());

    assertEquals(p1, resultado1);
    assertEquals(p2, resultado2);
    assertEquals(p3, resultado3);
  }
}
