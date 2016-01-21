package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class AdicionaPessoa {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_bean_validation_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final Pessoa pessoa = new Pessoa();
    // pessoa.setNome("Marcelo");

    manager.persist(pessoa);

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
