package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class AdicionaPessoa {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_hibernate_search_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final Pessoa p1 = new Pessoa();
    p1.setNome("Rafael Cosentino");

    final Pessoa p2 = new Pessoa();
    p2.setNome("Jonas Hirata");

    final Pessoa p3 = new Pessoa();
    p3.setNome("Marcelo Martins");

    final Pessoa p4 = new Pessoa();
    p4.setNome("Christopher Hirata");

    manager.persist(p1);
    manager.persist(p2);
    manager.persist(p3);
    manager.persist(p4);

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
