package com.github.mdssjc.k19.jpa.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Candidato;
import com.github.mdssjc.k19.jpa.modelo.Endereco;

public class AdicionaCandidatoEndereco {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

    final Endereco e = new Endereco();
    e.setEstado("São Paulo");
    e.setCidade("São Paulo");
    e.setLogradouro("Av. Brigadeiro Faria Lima");
    e.setNumero(1571);

    final Candidato p = new Candidato();
    p.setNome("Rafael Cosentino");
    p.setNascimento(new GregorianCalendar(1984, 10, 30));
    p.setEndereco(e);

    manager.persist(p);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}
