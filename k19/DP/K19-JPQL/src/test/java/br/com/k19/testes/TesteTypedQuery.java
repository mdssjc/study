package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.k19.modelo.Autor;

public class TesteTypedQuery {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    final TypedQuery<Autor> query = manager.createNamedQuery("Autor.findAll",
        Autor.class);
    final List<Autor> autores = query.getResultList();

    for (final Autor autor : autores) {
      System.out.println("Autor: " + autor.getNome());
    }

    manager.close();
    factory.close();
  }
}
