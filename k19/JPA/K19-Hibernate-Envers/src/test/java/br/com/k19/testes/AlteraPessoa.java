package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class AlteraPessoa {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_hibernate_envers_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final Pessoa p = manager.find(Pessoa.class, 1L);
    p.setNome("Marcelo Martins");

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
