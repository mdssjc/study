package com.github.mdssjc.k19.jpa.testes;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Pessoa;
import com.github.mdssjc.k19.jpa.modelo.PessoaFisica;
import com.github.mdssjc.k19.jpa.modelo.PessoaJuridica;

public class AdicionaPessoa {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

    final Pessoa p1 = new Pessoa();
    p1.setNome("Marcelo");

    final PessoaFisica p2 = new PessoaFisica();
    p2.setNome("Rafael");
    p2.setCpf("1234");

    final PessoaJuridica p3 = new PessoaJuridica();
    p3.setNome("K19");
    p3.setCnpj("567788");

    manager.persist(p1);
    manager.persist(p2);
    manager.persist(p3);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}
