package com.github.mdssjc.k19.jpa.testes;

import com.github.mdssjc.k19.jpa.modelo.Pessoa;
import com.github.mdssjc.k19.jpa.modelo.PessoaFisica;
import com.github.mdssjc.k19.jpa.modelo.PessoaJuridica;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class AdicionaPessoa extends JpaEntityManager {

  public static void main(final String[] args) {
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
  }
}
